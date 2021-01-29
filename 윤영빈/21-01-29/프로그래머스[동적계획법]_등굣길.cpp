#include <string>
#include <vector>

using namespace std;

int MOD = 1000000007;

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    vector<vector<int>> routes (n+1, vector<int> (m+1, 0));
    
    for (int i = 0; i < puddles.size(); i++) {
        int x = puddles[i][0];
        int y = puddles[i][1];
        routes[y][x] = -1;
    }
    
    for (int i = 1; i < m + 1; i++) {
        if (routes[1][i] == -1)
            break;
        routes[1][i] = 1;
    }
    for (int i = 1; i < n + 1; i++) {
        if (routes[i][1] == -1)
            break;
        routes[i][1] = 1;
    }
    
    for (int i = 2; i < n+1; i++) {
        for (int j = 2; j < m+1; j++) {
            if (routes[i][j] == -1)
                continue;
            
            // 위가 침수지역
            if (routes[i-1][j] == -1)
                routes[i][j] += routes[i][j-1] % MOD;
            // 왼쪽이 침수지역
            else if (routes[i][j-1] == -1)
                routes[i][j] += routes[i-1][j] % MOD;
            else 
                routes[i][j] += (routes[i-1][j] + routes[i][j-1]) % MOD;
        }
    }
    
    answer = routes[n][m] % MOD;
    return answer;
}
