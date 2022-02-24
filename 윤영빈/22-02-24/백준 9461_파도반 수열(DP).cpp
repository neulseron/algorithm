#include <iostream>
#include <vector>

using namespace std;

int T;

int main()
{
    cin >> T;

    vector<int> testCase (T);
    int maxCase = 0;
    for (int i = 0; i < T; i++) {
        cin >> testCase[i];
        maxCase = max(maxCase, testCase[i]);
    }

    vector<long long> P (maxCase+1);

    P[1] = 1;
    P[2] = 1;
    P[3] = 1;

    for (int i = 4; i <= maxCase; i++) {
        P[i] = P[i-3] + P[i-2];
    }

    for (int i = 0; i < T; i++) {
        cout << P[testCase[i]] << "\n";
    }
}
