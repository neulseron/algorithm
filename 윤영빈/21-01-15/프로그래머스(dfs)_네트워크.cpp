#include <string>
#include <vector>

using namespace std;

void dfs(int curr, vector<vector<int>>& com, vector<bool>& v) {
    v[curr] = true;
    for (int i = 0; i < com.size(); i++) {
        if (v[i] == false && com[curr][i] == 1) {
            v[i] = true;
            dfs(i, com, v);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<bool> visit (n, false);
    
    for (int i = 0; i < computers.size(); i++) {
        if (visit[i] == false) {
            dfs(i, computers, visit);
            answer++;
        }
    }
    
    return answer;
}
