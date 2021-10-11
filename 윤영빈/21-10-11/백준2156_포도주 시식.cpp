#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int N;
    cin >> N;

    vector<int> wines (N);
    for (int i = 0; i < N; i++) {
        cin >> wines[i];
    }

    vector<int> maxWines (N);
    maxWines[0] = wines[0];
    maxWines[1] = wines[0] + wines[1];
    maxWines[2] = max(maxWines[1], max(wines[0] + wines[2], wines[1] + wines[2]));

    for (int i = 3; i < N; i++) {
        maxWines[i] = max(maxWines[i-1], max(maxWines[i-3] + wines[i-1] + wines[i], maxWines[i-2] + wines[i]));
    }

    sort(maxWines.begin(), maxWines.end());

    cout << maxWines.back();
}
