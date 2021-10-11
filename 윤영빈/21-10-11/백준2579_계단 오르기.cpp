#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int N;
    cin >> N;

    vector<int> stairs (N);
    for (int i = 0; i < N; i++) {
        cin >> stairs[i];
    }

    vector<int> maxScore (N, 0);
    maxScore[0] = stairs[0];
    maxScore[1] = stairs[0] + stairs[1];    // 건너뛰는 것 보다 둘다 밟는게 무조건 점수 더 높음
    maxScore[2] = max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

    for (int i = 3; i < N; i++) {
        maxScore[i] = max(maxScore[i-2] + stairs[i], maxScore[i-3] + stairs[i-1] + stairs[i]);
    }

    cout << maxScore.back();
}
