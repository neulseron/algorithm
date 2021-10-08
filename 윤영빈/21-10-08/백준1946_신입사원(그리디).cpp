#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
    return a.first < b.first;
}

int main()
{
    int T;
    cin >> T;
    vector<vector<pair<int, int>>> data (T);

    for (int i = 0; i < T; i++) {
        int N;
        cin >> N;

        for (int j = 0; j < N; j++) {
            int paper, interview;
            cin >> paper >> interview;
            data[i].push_back({paper, interview});
        }
    }

    for (int i = 0; i < T; i++) {
        sort(data[i].begin(), data[i].end(), cmp);

        int max = data[i][0].second;
        int cnt = 0;
        for (int j = 0; j < data[i].size(); j++) {
            if (data[i][j].second <= max) {
                cnt++;
                max = data[i][j].second;
            }
        }

        cout << cnt << endl;
    }
}
