#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer;
    
    // 삼각형 초기화
    vector<vector<int>> triangle (n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            triangle[i].push_back(0);
        }
    }
    
    // 종료 조건 값 계산
    int end = 0;
    for (int i = 1; i <= n; i++)
        end += i;
    
    // 삼각형에 값 대입
    int num = 1;
    int left = 0, down = n-1, right = 0;
    while (1) {
        // left
        for (int i = left; i <= down; i++)
            if (triangle[i][left] == 0)
                triangle[i][left] = num++;
        left++;
        
        if (num > end)
            break;
        
        // down
        for (int i = left; i <= down; i++)
            if (triangle[down][i] == 0)
                triangle[down][i] = num++;
        down--;
        
        if (num > end)
            break;
        
        // right
        for (int i = down; i >= left; i--)
            if (triangle[i][i- right] == 0)
                triangle[i][i-right] = num++;
        right++;
        
        if (num > end)
            break;
    }
    
    // 답
    for (int i = 0; i < n; i++)
        for (int j = 0; j <= i; j++) {
            answer.push_back(triangle[i][j]);
        }
    
    return answer;
}
