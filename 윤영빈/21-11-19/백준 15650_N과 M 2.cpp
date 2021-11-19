#include <iostream>
#include <vector>
#include <string>

using namespace std;

int N, M;

vector<bool> visited;

void dfs(string str, int idx)
{
    if (str.length() == M) {
        for (int i = 0; i < M; i++) {
            cout << (str[i] - '0') + 1 << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = idx; i < N; i++) {
        dfs(str + to_string(i), i+1);
    }
}

int main()
{
    cin >> N >> M;
    visited.assign(N, false);

    dfs("", 0);
}
