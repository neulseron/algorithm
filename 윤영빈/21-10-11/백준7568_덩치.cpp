#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int N;
    cin >> N;

    vector<pair<int, int>> data (N);
    for (int i = 0; i < N; i++) {
        int x, y;
        cin >> x >> y;
        data[i] = {x, y};
    }

    vector<int> answer (N, 0);
    for (int me = 0; me < N; me++) {
        for (int j = 0; j < N; j++) {
            if (me != j) {
                if (data[j].first > data[me].first &&
                    data[j].second > data[me].second) {
                        answer[me]++;
                }
            }
        }

        answer[me]++;
    }

    for (int i = 0; i < N; i++)
        cout << answer[i] << " ";
}
