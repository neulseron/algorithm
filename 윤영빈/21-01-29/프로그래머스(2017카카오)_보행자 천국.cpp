#include <vector>

using namespace std;

int MOD = 20170805;

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int m, int n, vector<vector<int>> city_map) {
    int answer = 0;
    vector<vector<vector<int>>> route (2, vector<vector<int>> (m, vector<int> (n, 0)));
    
    // 초기화 / 0 : down, 1 : right
    for (int i = 0; i < m; i++) {
        if (city_map[i][0] == 1)
            break;
        
        route[0][i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
        if (city_map[0][i] == 1)
            break;
        
        route[1][0][i] = 1;
    }
    
    // 경로 계산
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            // 위쪽이 0
            if (city_map[i-1][j] == 0) {
                route[0][i][j] += (route[0][i-1][j] + route[1][i-1][j]) % MOD;
            }
            // 위쪽이 2
            else if (city_map[i-1][j] == 2) {
                route[0][i][j] += (route[0][i-1][j]) % MOD;
            }
            
            // 왼쪽이 0
            if (city_map[i][j-1] == 0)
                route[1][i][j] += (route[0][i][j-1] + route[1][i][j-1]) % MOD;
            // 왼쪽이 2
            else if (city_map[i][j-1] == 2)
                route[1][i][j] += (route[1][i][j-1]) % MOD;
        }
    }

    answer = route[0][m-1][n-1] + route[1][m-1][n-1];
    return answer % MOD;
}
