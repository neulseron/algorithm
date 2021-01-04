#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(string name) {
    int answer = 0;
    
    string cmp (name.length(), 'A');

    int curr = 0;
    while (1) {
        // A~Z 값
        int A = -('A' - name[curr]);
        int minUpDown = min(A, 25 - A + 1);
        name[curr] = 'A'; // 횟수 계산했으면 A로 변경
        answer += minUpDown;
        
        if (cmp == name) break;
        
        // 좌우이동
        int right = 0, left = 99; // 거리
        int rid = 0, lid = 0; // 찾은 위치
        // 오른쪽 계산
        for (int i = curr + 1; ; i++) {
            int k = i % name.length();
            if (name[k] != 'A') {
                right = i - curr;
                rid = k;
                break;
            }
        }
        // 왼쪽 계산
        for (int i = curr - 1; ; i--) {
            int k = (i + name.length()) % name.length();
            if (name[k] != 'A') {
                left = curr - i;
                lid = k;
                
                break;
            }
        }
        
        if (left < right) { // 왼쪽이 가까우면
            curr = lid;
            answer += left;
        } else { // 같거나 오른쪽이 가까우면
            curr = rid;
            answer += right;
        }
    }
    
    return answer;
}
