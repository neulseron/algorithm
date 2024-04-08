#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <string>
#include <tuple>
#include <map>

using namespace std;

bool cmp(const vector<string> &a, const vector<string> &b)
{
    return a[1] < b[1];
}

map<string, tuple<int, int>> ConvertPlans(vector<vector<string>> plans)
{
    map<string, tuple<int, int>> converted;

    for (int i = 0; i < plans.size(); ++i)
    {
        int startMin = stoi(plans[i][1].substr(0, 2)) * 60 + stoi(plans[i][1].substr(3, 2));
        int playMin = stoi(plans[i][2]);

        converted[plans[i][0]] = make_tuple(startMin, playMin);
    }

    return converted;
}

vector<string> solution(vector<vector<string>> plans)
{
    vector<string> answer;

    sort(plans.begin(), plans.end(), cmp);

    map<string, tuple<int, int>> plansMap = ConvertPlans(plans);

    stack<string> stackPlans;
    stackPlans.push(plans[0][0]);

    int lastFinishTime = get<0>(plansMap[stackPlans.top()]);

    for (int i = 1; i < plans.size(); ++i)
    {
        int prevLeftTime = get<1>(plansMap[stackPlans.top()]);
        int prevStartTime = get<0>(plansMap[stackPlans.top()]);
        int prevEndTime = prevStartTime + prevLeftTime;

        int currStartTime = get<0>(plansMap[plans[i][0]]);
        int currEndTime = currStartTime + get<1>(plansMap[plans[i][0]]);

        if (prevEndTime == currStartTime)
        {
            lastFinishTime = currEndTime;

            answer.push_back(stackPlans.top());
            stackPlans.pop();

            stackPlans.push(plans[i][0]);
        }
        else if (prevEndTime > currStartTime)
        {
            lastFinishTime = currEndTime;

            plansMap[stackPlans.top()] = make_tuple(lastFinishTime, prevLeftTime - (currStartTime - prevStartTime));

            stackPlans.push(plans[i][0]);
        }
        else 
        {
            while (stackPlans.empty() == false && prevEndTime < currStartTime)
            {
                lastFinishTime = prevEndTime;

                answer.push_back(stackPlans.top());
                stackPlans.pop();

                if (stackPlans.empty() == false)
                {
                    prevEndTime = lastFinishTime + get<1>(plansMap[stackPlans.top()]);
                }
            }

            if (stackPlans.empty() == false)
            {
                plansMap[stackPlans.top()] = make_tuple(lastFinishTime, get<1>(plansMap[stackPlans.top()]));
                 i--;
                continue;
            }
            else
            {
                stackPlans.push(plans[i][0]);
                lastFinishTime = currEndTime;
            }
        }
    }

    while (stackPlans.empty() == false)
    {
        answer.push_back(stackPlans.top());
        stackPlans.pop();
    }

    return answer;
}
