#include <iostream>
#include <vector>
#include <string>
#include <stack>
#include <queue>

using namespace std;

int N, M;
vector<vector<int>> maze;
vector<vector<int>> cnt;
vector<vector<bool>> visit;

pair<int, int> dir [4] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

void bfs()
{
    queue<pair<int, int>> nextCoordStk;
    //stack<pair<int, int>> nextCoordStk;
    nextCoordStk.push({0, 0});

    cnt[0][0] = 1;
    visit[0][0] = true;

    while (!nextCoordStk.empty()) {
        //pair<int, int> currCoord = nextCoordStk.top();
        pair<int, int> currCoord = nextCoordStk.front();
        nextCoordStk.pop();

        pair<int, int> nextCoord;
        for (int i = 0; i < 4; i++) {
            nextCoord = { currCoord.first + dir[i].first, currCoord.second + dir[i].second };

            if (nextCoord.first >= 0 && nextCoord.second >= 0 && nextCoord.first < N && nextCoord.second < M) {
                if (maze[nextCoord.first][nextCoord.second] == 1 && !visit[nextCoord.first][nextCoord.second]) {
                    nextCoordStk.push(nextCoord);
                    cnt[nextCoord.first][nextCoord.second] = cnt[currCoord.first][currCoord.second] + 1;
                    visit[nextCoord.first][nextCoord.second] = true;
                }
            }
        }
    }
}

int main()
{
    cin >> N >> M;

    maze.assign(N, vector<int> (M, 0));
    cnt.assign(N, vector<int> (M, 0));
    visit.assign(N, vector<bool> (M, false));

    for (int i = 0; i < N; i++) {
        string str; cin >> str;

        for (int j = 0; j < str.length(); j++) {
            maze[i][j] = str[j] - '0';
        }
    }

    bfs();

    cout << cnt[N-1][M-1];
}
