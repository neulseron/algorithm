#include <iostream>
#include <vector>
#include <string>

using namespace std;

int N, M;

vector<bool> visited;

void dfs(string str)
{
    if (str.length() == M) {
        for (int i = 0; i < M; i++) {
            cout << (str[i] - '0') + 1 << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = 0; i < N; i++) {
        if (!visited[i]) {
            visited[i] = true;
            dfs(str + to_string(i));
            visited[i] = false;
        }
    }
}

int main()
{
    cin >> N >> M;
    visited.assign(N, false);

    dfs("");
}
