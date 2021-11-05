#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <unordered_map>

using namespace std;

int main()
{
    int N;
    cin >> N;

    vector<int> dataArr (N);
    int first = 0;
    for (int i = 0; i < N; i++) {
        cin >> dataArr[i];
        first += dataArr[i];
    }
    first = round((float)first / N);

    sort(dataArr.begin(), dataArr.end());
    int min = dataArr.front();
    int max = dataArr.back();

    int second = dataArr[N/2];
    int fourth = max - min;

    unordered_map<int, int> hashMap;
    for (int i = 0; i < N; i++) {
        hashMap[dataArr[i]] = 0;
    }
    for (int i = 0; i < N; i++) {
        hashMap[dataArr[i]]++;
    }
    vector<pair<int, int>> hashVec (hashMap.begin(), hashMap.end());
    sort(hashVec.begin(), hashVec.end(), 
        [](pair<int, int> a, pair<int, int> b) { return a.second > b.second;  });
    
    int third, freqIndex = 0;
    while (hashVec[freqIndex].second == hashVec.front().second) {
        freqIndex++;
    }

    if (freqIndex == 1) {
        third = hashVec.front().first;
    } else {
        sort(hashVec.begin(), hashVec.begin() + freqIndex, 
        [](pair<int, int> a, pair<int, int> b) { return a.first < b.first;  });
        third = hashVec[1].first;
    }


    cout << first << "\n";
    cout << second << "\n";
    cout << third << "\n";
    cout << fourth << "\n";
}
