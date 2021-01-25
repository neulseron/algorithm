#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int m, n, k;
int cnt;

vector<pair<int, int>> dir = { {1, 0}, {0, -1},
                               {-1, 0}, {0, 1} };


void dfs(int x, int y, vector<vector<int>>& p, vector<vector<bool>>& v) {
    cnt++;
    v[x][y] = true;

    for (int i = 0; i < 4; i++) {
        int next_x = x + dir[i].first;
        int next_y = y + dir[i].second;

        if (next_x >= 0 && next_y >= 0 && next_x < n && next_y < m)
            if (p[next_x][next_y] == 0 && !v[next_x][next_y]) {
                dfs(next_x, next_y, p, v);
            }
    }
}

int main() {
    //input
    cin>>m>>n>>k;

    // mark rec
    vector<vector<int>> plane (n, vector<int>(m, 0));
    for (int i = 0; i < k; i++) {
        int start_x, end_x, start_y, end_y;
        cin>>start_x>>start_y>>end_x>>end_y;

        for (int x = start_x; x < end_x; x++) {
            for (int y = start_y; y < end_y; y++) {
                plane[x][y] = 1;
            }
        }
    }

    // dfs
    vector<int> area;
    vector<vector<bool>> visit (n, vector<bool>(m, false));
    for (int x = 0; x < n; x++) {
        for (int y = 0; y < m; y++) {
            if (plane[x][y] == 0 && !visit[x][y]) {
                cnt = 0;
                dfs(x, y, plane, visit);
                area.push_back(cnt);
            }
        }
    }

    // print
    sort(area.begin(), area.end());
    cout<<area.size()<<"\n";
    for (int i = 0; i < area.size(); i++)  {
        cout<<area[i]<<" ";
    }
    cout<<"\n";
}
