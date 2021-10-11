#include <iostream>
#include <vector>

using namespace std;

string white[8] = { "WBWBWBWB",
                    "BWBWBWBW",
                    "WBWBWBWB",
                    "BWBWBWBW",
                    "WBWBWBWB",
                    "BWBWBWBW",
                    "WBWBWBWB",
                    "BWBWBWBW" };

string black[8] = { "BWBWBWBW",
                    "WBWBWBWB",
                    "BWBWBWBW",
                    "WBWBWBWB",
                    "BWBWBWBW",
                    "WBWBWBWB",
                    "BWBWBWBW",
                    "WBWBWBWB" };

int chkWhite(int x, int y, const vector<string>& data)
{
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (data[x + i][y + j] != white[i][j]) 
                cnt++;
        }
    }
    return cnt;
}

int chkBlack(int x, int y, const vector<string>& data)
{
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (data[x + i][y + j] != black[i][j]) 
                cnt++;
        }
    }
    return cnt;
}

int main()
{
    int N, M;
    cin >> N >> M;

    vector<string> data (N);
    for (int i = 0; i < N; i++) {
        cin >> data[i];
    }

    int minNum = N * M;
    for (int i = 0; i < N - 8 + 1; i++) {
        for (int j = 0; j < M - 8 + 1; j++) {
            minNum = min(minNum, min(chkWhite(i, j, data), chkBlack(i, j, data)));
        }
    }

    cout << minNum;
}
