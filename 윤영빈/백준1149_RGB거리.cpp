#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int N;
    cin >> N;

    vector<vector<int>> cost (N, vector<int> (3));
    for (int i = 0; i < N; i++) {
        cin >> cost[i][0] >> cost[i][1] >> cost[i][2];
    }

    int coloring[1000][3];  // i번째 집을 j색으로 칠했을때 최소값
    coloring[0][0] = cost[0][0];
    coloring[0][1] = cost[0][1];
    coloring[0][2] = cost[0][2];
    for (int i = 1; i < N; i++) {
        coloring[i][0] = min(coloring[i-1][1], coloring[i-1][2]) + cost[i][0];
        coloring[i][1] = min(coloring[i-1][0], coloring[i-1][2]) + cost[i][1];
        coloring[i][2] = min(coloring[i-1][1], coloring[i-1][0]) + cost[i][2];
    }

    cout << min(coloring[N-1][0], min(coloring[N-1][1], coloring[N-1][2]));
}
