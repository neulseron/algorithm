#include <iostream>
#include<vector>
using namespace std;

int solution(vector<vector<int>> board)
{
    int answer = 0;
    for (int j = 0; j < board[0].size(); j++) {
        if (board[0][j] == 1) {
            answer = 1;
            break;
        }
    }
    
    vector<vector<int>> dp (board);
    for (int i = 1; i < board.size(); i++) {
        for (int j = 1; j < board[0].size(); j++) {
            if (board[i][j] == 1) {
                dp[i][j] = min(dp[i-1][j], min(dp[i][j-1], dp[i-1][j-1])) + 1;
                answer = max(answer, dp[i][j]);
            }
        }
    }

    return answer * answer;
}
