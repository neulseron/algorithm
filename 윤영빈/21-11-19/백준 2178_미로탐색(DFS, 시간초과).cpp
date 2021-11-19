#include <iostream>
#include <vector>
#include <string>
#include <climits>
#include <stack>

using namespace std;

int N, M;
vector<vector<int>> maze;
int minCnt = INT_MAX;

pair<int, int> dir [4] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

bool ChkAllVisit(const vector<vector<bool>>& visit)
{
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (maze[i][j] == 1 && !visit[i][j])
                return false;
        }
    }

    return true;
}

void dfs(vector<vector<bool>> visit, pair<int, int> currCoord, int cnt)
{
    if (currCoord.first == N-1 && currCoord.second == M-1) {
        minCnt = min(minCnt, cnt);
        return;
    } else if (ChkAllVisit(visit)) {
        return;
    }

    pair<int, int> nextCoord;
    for (int i = 0; i < 4; i++) {
        nextCoord = { currCoord.first + dir[i].first, currCoord.second + dir[i].second };

        if (nextCoord.first >= 0 && nextCoord.second >= 0 && nextCoord.first < N && nextCoord.second < M) {
            if (maze[nextCoord.first][nextCoord.second] == 1 && !visit[nextCoord.first][nextCoord.second]) {
                visit[nextCoord.first][nextCoord.second] = true;
                dfs(visit, nextCoord, cnt + 1);
                visit[nextCoord.first][nextCoord.second] = false;
            }
        }
    }
}

int main()
{
    cin >> N >> M;

    maze.assign(N, vector<int> (M, 0));
    for (int i = 0; i < N; i++) {
        string str; cin >> str;

        for (int j = 0; j < str.length(); j++) {
            maze[i][j] = str[j] - '0';
        }
    }

    vector<vector<bool>> visit (N, vector<bool> (M, false));
    dfs(visit, { 0, 0 }, 1);

    cout << minCnt;
}
