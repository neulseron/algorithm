
/*플로이드 와샬 알고리즘*/
#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<vector<int>> results) {
    int answer = 0;

    // 승패 기록
    vector<vector<bool>> chkResult (n, vector<bool> (n, false));
    for (auto i : results)
        chkResult[i[0]-1][i[1]-1] = true;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (chkResult[j][i] && chkResult[i][k]) 
                    chkResult[j][k] = true;
            }
        }
    }

    for (int i = 0; i < n; i++) {
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            if (chkResult[i][j] || chkResult[j][i])
                cnt++;
        }
        if (cnt == n-1)
            answer++;
    }

    return answer;
}
