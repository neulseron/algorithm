#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    int size = board.size();
    stack<int> basket;
    
    for (int i = 0; i < moves.size(); i++) {
        for (int x = 0; x < size; x++) {
            if (board[x][moves[i]-1] != 0) {
                if (!basket.empty() && basket.top() == board[x][moves[i]-1]) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(board[x][moves[i]-1]);
                }
                
                board[x][moves[i]-1] = 0;
                break;
            }
        }
    }
    
    return answer;
}
