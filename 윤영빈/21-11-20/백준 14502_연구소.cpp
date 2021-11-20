#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

#define MAX 8

using namespace std;
    
int N, M;

int labsMap [MAX][MAX];
int virusMap [MAX][MAX];

int walls [MAX * MAX];

int answer = -1;

pair<int, int> dir [4] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

void spreadVirus(pair<int, int> coord)
{
    queue<pair<int, int>> nextVisitQue;
    nextVisitQue.push(coord);

    while (!nextVisitQue.empty()) {
        pair<int, int> currCoord = nextVisitQue.front();
        nextVisitQue.pop();

        for (int i = 0; i < 4; i++) {
            pair<int, int> nextCoord = { currCoord.first + dir[i].first, currCoord.second + dir[i].second };

            if (nextCoord.first >= 0 && nextCoord.second >= 0 && nextCoord.first < N && nextCoord.second < M) {
                if (virusMap[nextCoord.first][nextCoord.second] == 0) {
                    virusMap[nextCoord.first][nextCoord.second] = 2;
                    nextVisitQue.push(nextCoord);
                }
            }
        }
    }
}

void makeWalls(int idx, int cnt, const vector<pair<int, int>>& virusCoord, int w [MAX * MAX])
{
    if (cnt == 3) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = w[j + M * i];
            }
        }

        copy(walls, walls + MAX * MAX, w);

        for (int i = 0; i < virusCoord.size(); i++) {
            spreadVirus(virusCoord[i]);
        }


        int safe = 0;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (virusMap[n][m] == 0) {
                    safe++;
                } 
            }
        }

        answer = max(answer, safe);

        return;
    }

    for (int i = idx; i < N * M; i++) {
        if (w[i] == 0) {
            w[i] = 1;
            makeWalls(i, cnt + 1, virusCoord, w);
            w[i] = 0;
        }
    }
}

int main()
{
    cin >> N >> M;

    vector<pair<int, int>> virusCoord;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> labsMap[i][j];
            walls[j + M * i] = labsMap[i][j];
            if (labsMap[i][j] == 2)
                virusCoord.push_back({i, j});
        }
    }

    makeWalls(0, 0, virusCoord, walls);

    cout << answer;
}
