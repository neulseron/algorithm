#include <iostream>
#include <vector>
#include <string>
#include <set>
#include <algorithm>
#include <map>

using namespace std;

long long solution(vector<int> weights)
{
    long long answer = 0;

    sort(weights.begin(), weights.end());

    map<int, long long> mWeights;
    for (int i = 0; i < weights.size(); ++i)
    {
        mWeights[weights[i]]++;
    }
    weights.erase(unique(weights.begin(), weights.end()), weights.end());

    set<long long> iset;
    for (int i = 0; i < weights.size() - 1; ++i)
    {
        for (int j = i + 1; j < weights.size(); ++j)
        {
            iset.clear();
            iset.insert(weights[i] * 2);
            iset.insert(weights[i] * 3);
            iset.insert(weights[i] * 4);
            iset.insert(weights[j] * 2);
            iset.insert(weights[j] * 3);
            iset.insert(weights[j] * 4);

            if (iset.size() < 6)
            {
                answer += mWeights[weights[i]] * mWeights[weights[j]];
            }
        }
    }

    for (auto weight : mWeights)
    {
        if (weight.second >= 2)
            answer += (weight.second * (weight.second - 1)) / 2;
    }

    return answer;
}
