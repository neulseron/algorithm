#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
    if (a.second == b.second) {
        return a.first < b.first;
    }

    return a.second < b.second;
}

int main()
{
    int N;
    cin >> N;

    vector<pair<int, int>> data (N);
    for (int i = 0; i < N; i++) {
        cin >> data[i].first >> data[i].second;
    }

    sort(data.begin(), data.end(), cmp);

    for (int i = 0; i < N; i++) {
        cout << data[i].first << " " << data[i].second << "\n";
    }
}
