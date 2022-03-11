#include <iostream>
#include <vector>

using namespace std;

int N;

int main()
{
    cin >> N;
    vector<int> seq (N);
    for (int i = 0; i < N; i++) {
        cin >> seq[i];
    }

    int answer = 0;
    vector<int> dp (N, 1);
    for (int curr = 0; curr < N; curr++) {
        for (int last = curr - 1; last >= 0; last--) {
            if (seq[curr] > seq[last]) {
                dp[curr] = max(dp[curr], dp[last] + 1);
            }
        }
        answer = max(answer, dp[curr]);
    }

    cout << answer;
}
