#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N;
vector<vector<int>> maps;
vector<vector<bool>> visit;

pair<int, int> dir [4] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

void bfs(pair<int, int> coord, int& cnt)
{
    queue<pair<int, int>> nextCoordQue;
    nextCoordQue.push(coord);
    visit[coord.first][coord.second] = true;

    while (!nextCoordQue.empty()) {
        pair<int, int> currCoord = nextCoordQue.front();
        nextCoordQue.pop();

        pair<int, int> nextCoord;
        for (int i = 0; i < 4; i++) {
            nextCoord = { currCoord.first + dir[i].first, currCoord.second + dir[i].second };

            if (nextCoord.first >= 0 && nextCoord.second >= 0 && nextCoord.first < N && nextCoord.second < N) {
                if (maps[nextCoord.first][nextCoord.second] != 0 && !visit[nextCoord.first][nextCoord.second]) {
                    nextCoordQue.push(nextCoord);
                    visit[nextCoord.first][nextCoord.second] = true;
                    cnt++;
                }
            }
        }
    }
}

int main()
{
    cin >> N;
    visit.assign(N, vector<bool> (N, false));

    maps.assign(N, vector<int> (N));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            scanf("%1d", &maps[i][j]);
        }
    }

    vector<int> cntVec;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (maps[i][j] != 0 && !visit[i][j]) {
                int cnt = 1;
                bfs({i, j}, cnt);
                cntVec.push_back(cnt);
            }
        }
    }

    sort(cntVec.begin(), cntVec.end());
    
    cout << cntVec.size() << "\n";
    for (int i = 0; i < cntVec.size(); i++) {
        cout << cntVec[i] << "\n";
    }
}
