#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

bool cmp(const pair<int, float> &a, const pair<int, float> &b)
{
    if (a.second == b.second)
        return a.first < b.first;
    
    return a.second > b.second;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer (N);
    
    vector<int> clear (N + 1, 0);
    map<int, int> challenge;
    for (int i = 1; i <= N + 1; i++)    challenge[i] = 0;
    
    for (int i = 0; i < stages.size(); i++) {
        for (int j = 1; j < stages[i]; j++) {
            clear[j]++;
        }
        challenge[stages[i]]++;
    }

    vector<pair<int, float>> fail (N+1);
    for (int i = 1; i <= N; i++) {
        if ((float)clear[i] + (float)challenge[i] == 0) {
            fail[i] = {i, 0};
        } else {
            fail[i] = { i, (float)challenge[i] / ((float)clear[i] + (float)challenge[i]) };
        }
    }
    
    sort(fail.begin() + 1, fail.end(), cmp);
    
    for (int i = 1; i <= N; i++) {
        answer[i-1] = fail[i].first;
    }
    
    
    return answer;
}
