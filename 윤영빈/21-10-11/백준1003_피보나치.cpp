#include <iostream>
#include <vector>

using namespace std;

int calcFibo(int n)
{
    vector<int> fibo(n+1, 0);
    fibo[1] = 1;

    for (int i = 2; i <= n; i++) {
        fibo[i] = fibo[i-1] + fibo[i-2];
    }

    return fibo[n];
}

int main()
{
    int T;
    cin >> T;

    vector<int> test (T);
    for (int i = 0; i < T; i++) {
        cin >> test[i];
    }

    vector<pair<int, int>> answer (T);
    for (int i = 0; i < T; i++) {
        if (test[i] == 0) {
            answer[i] = {1, 0};
            continue;
        } else if (test[i] == 1) {
            answer[i] = {0, 1};
            continue;
        }

        answer[i] = { calcFibo(test[i]-1), calcFibo(test[i]) };
    }

    for (int i = 0; i < T; i++) {
        cout << answer[i].first << " " << answer[i].second << endl;
    }
}
