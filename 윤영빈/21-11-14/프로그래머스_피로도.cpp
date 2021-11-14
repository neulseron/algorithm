#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    int N = dungeons.size();
    
    vector<int> order (N);
    for (int i = 0; i < N; i++) {
        order[i] = i;
    }
    
    do {
        int tmpK = k, cnt = 0;
        
        for (int i = 0; i < N; i++) {
            if (tmpK >= dungeons[order[i]][0]) {
                tmpK -= dungeons[order[i]][1];
                cnt++;
            } else {
                break;
            }
        }
        
        answer = max(answer, cnt);
    } while (next_permutation(order.begin(), order.end()));
    
    return answer;
}
