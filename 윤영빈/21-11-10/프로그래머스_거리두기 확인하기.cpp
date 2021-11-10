#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    
    for (int roomNum = 0; roomNum < 5; roomNum++) {
        int room[5][5] = {};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (places[roomNum][i][j] == 'P') {
                    if (i - 1 >= 0) // 상
                        room[i - 1][j] += -1;
                    if (j - 1 >= 0) // 좌
                        room[i][j - 1] += -1;
                    if (j + 1 < 5)
                        room[i][j + 1] += -1;
                    if (i + 1 < 5)
                        room[i + 1][j] += -1;
                    
                    room[i][j] += -1;
                } else if (places[roomNum][i][j] == 'X') {
                    room[i][j] += 5;
                }
            }
        }
        
        bool chk = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (room[i][j] < -1) {
                    chk = false;
                    break;
                }
            }
            if (!chk)   break;
        }
        
        if (chk)    answer.push_back(1);
        else        answer.push_back(0);
    }
    
    return answer;
}
