#include <iostream>
#include <vector>
#include <queue>
#include <set>

using namespace std;

pair<int, int> dir[4] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

void bfs(const int& M, const int& N, const vector<vector<int>>& farm, vector<vector<bool>>& visit, const pair<int, int>& start) 
{
    set<pair<int, int>> found;
    queue<pair<int, int>> willVisit;
    
    willVisit.push(start);
    visit[start.first][start.second] = true;
    
    while(!willVisit.empty()) {
        pair<int, int> curr = willVisit.front(); willVisit.pop();
        
        if (found.find(curr) != found.end())    continue;
        found.insert(curr);
        
        for (int i = 0; i < 4; i++) {
            pair<int, int> next = {curr.first + dir[i].first, curr.second + dir[i].second};
            
            if (next.first < 0 || next.second < 0 || next.first >= M || next.second >= N) continue;
            
            if (visit[next.first][next.second]) continue;
            visit[next.first][next.second] = true;
            
            if (farm[next.first][next.second] == 1)
                willVisit.push(next);
        }
    }
}

int main()
{
    int T, M, N, K;
    cin >> T;
    
    vector<vector<vector<int>>> farm (T);
    vector<int> answer (T);
    
    int x, y;
    for (int i = 0; i < T; i++) {
        cin >> M >> N >> K;
        
        vector<vector<int>> f (M, vector<int> (N, 0));
        vector<vector<bool>> v (M, vector<bool> (N, false));
        vector<pair<int, int>> c (K);
        
        farm[i] = f;
        
        for (int j = 0; j < K; j++) {
            cin >> x >> y;
            farm[i][x][y] = 1;
            c[j] = {x, y};
        }
        
        int cnt = 0;
        for (int j = 0; j < K; j++) {
            if (v[c[j].first][c[j].second]) continue;
            
            cnt++;
            bfs(M, N, farm[i], v, c[j]);
        }
        answer[i] = cnt;
    }
    
    for (int i = 0; i < T; i++) {
        cout << answer[i] << "\n";
    }
}
