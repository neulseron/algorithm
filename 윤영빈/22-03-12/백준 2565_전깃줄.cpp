#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;

int main()
{
    cin >> N;
    vector<pair<int, int>> lines (N);
    for (int i = 0; i < N; i++) {
        cin >> lines[i].first >> lines[i].second;
    }
    sort(lines.begin(), lines.end());

    int maxDp = 0;
    vector<int> dp (N, 1);
    for (int i = 0; i < N; i++) {
        for (int j = i - 1; j >= 0; j--) {
            if (lines[i].second > lines[j].second) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        maxDp = max(maxDp, dp[i]);
    }

    cout << N - maxDp;
}
