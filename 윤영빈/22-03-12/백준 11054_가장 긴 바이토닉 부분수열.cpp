#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;

int main()
{
    cin >> N;
    vector<int> seq1 (N);
    for (int i = 0; i < N; i++) {
        cin >> seq1[i];
    }
    vector<int> seq2 (seq1);
    reverse(seq2.begin(), seq2.end());

    vector<int> dp1 (N, 1); 
    vector<int> dp2 (N, 0);
    for (int curr = 0; curr < N; curr++) {
        for (int last = curr - 1; last >= 0; last--) {
            if (seq1[curr] > seq1[last]) {
                dp1[curr] = max(dp1[curr], dp1[last] + 1);
            }

            if (seq2[curr] > seq2[last]) {
                dp2[curr] = max(dp2[curr], dp2[last] + 1);
            }
        }
    }
    reverse(dp2.begin(), dp2.end());


    int answer = 0;
    for (int i = 0; i < N; i++) {
        answer = max(answer, dp1[i] + dp2[i]);
        //cout << "answer : " << answer << " / i = " << i << "\n";
    }
    cout << answer;
}
