#include <iostream>
#include <vector>

using namespace std;

int N;

int main()
{
    cin >> N;
    vector<vector<int>> tri (N);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j <= i; j++) {
            int n;  cin >> n;
            tri[i].push_back(n);
        }
    }

    vector<vector<int>> sum (tri);
    for (int i = 1; i < N; i++) {
        for (int j = 0; j <= i; j++) {
            if (j == 0) {
                sum[i][j] = sum[i-1][j] + tri[i][j];
            } else if (j == i) {
                sum[i][j] = sum[i-1][j-1] + tri[i][j];
            } else {
                sum[i][j] = max(sum[i-1][j-1] + tri[i][j], sum[i-1][j] + tri[i][j]);
            }
        }
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
        answer = max(answer, sum[N-1][i]);
    }
    cout << answer;
}
