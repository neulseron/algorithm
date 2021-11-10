#include <algorithm>
#include <cstdlib>
#include <string>
#include <vector>
#include <iostream>

using namespace std;

char kFriends[8] = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };

int findIndex(const vector<char>& order, char& a)
{
    for (int i = 0; i < 8; i++) {
        if (order[i] == a)
            return i;
    }
}

int solution(int n, vector<string> data) {
    int answer = 0;
    vector<char> order (kFriends, kFriends + sizeof(kFriends)/sizeof(char));
    
    do {
        bool chkCond = true;
        
        for (int i = 0; i < n; i++) {
            char A = data[i][0];
            char B = data[i][2];
            char E = data[i][3];
            int D = data[i][4] - '0' + 1; // ex) 사이에 아무도 없어야 할 경우 값은 '상대 인덱스-내 인덱스=1' 이어야 함
            
            int distance = abs(findIndex(order, A) - findIndex(order, B));
            
            switch (E) {
                case '=':
                    if (distance != D) {
                        chkCond = false;
                    }
                    break;
                case '<':
                    if (distance >= D) {
                        chkCond = false;
                    }
                    break;
                case '>':
                    if (distance <= D) {
                        chkCond = false;
                    }
                    break;
            }
        }
        
        if (chkCond)    answer++;
    } while (next_permutation(order.begin(), order.end()));
    
    return answer;
}
