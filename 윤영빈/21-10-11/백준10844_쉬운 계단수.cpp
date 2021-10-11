#include <iostream>
#include <vector>

using namespace std;

const int mod = 1000000000;

int main()
{
    int N;
    cin >> N;

    vector<vector<int>> dp (N + 1, vector<int>(10, 0));     // 길이 x 끝자리 수
    for (int j = 1; j < 10; j++) {
        dp[1][j] = 1; 
    }

    for (int i = 2; i <= N; i++) {
        for (int j = 0; j < 10; j++) {
            if (j == 0) {
                dp[i][j] = dp[i-1][j+1];
            } else if (j == 9) {
                dp[i][j] = dp[i-1][j-1];
            } else {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
            }
            
            dp[i][j] %= mod;
        }
    }

    int answer = 0;
    for (int j = 0; j < 10; j++) {
        answer = (answer + dp[N][j]) % mod;
    }

    cout << answer;
}
