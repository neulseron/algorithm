#include <iostream>
#include <vector>
#include <queue>
using namespace std;

#define MAX 10001

vector<pair<int, int>> dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

int solution(vector<vector<int>> maps)
{
    int N = maps.size(), M = maps[0].size();
    
    vector<vector<int>> dist (N, vector<int>(M, MAX));
    dist[0][0] = 0;
    
    queue<pair<int, int>> pos;
    pos.push(make_pair(0, 0));
    
    while (!pos.empty()) {
        int x = pos.front().first;
        int y = pos.front().second;
        pos.pop();
        
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i].first;
            int nextY = y + dir[i].second;

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if (maps[nextX][nextY] == 0)    continue;
                
                if (dist[nextX][nextY] > dist[x][y] + 1) {
                    pos.push(make_pair(nextX, nextY));
                    dist[nextX][nextY] = dist[x][y] + 1;
                }
            }
        }
    }
    
    if (dist[N-1][M-1] == MAX)
        return -1;
    else 
        return dist[N-1][M-1] + 1;
}
