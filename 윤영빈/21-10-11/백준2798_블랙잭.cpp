#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int N, target;
    cin >> N >> target;

    vector<int> cards (N);
    for (int i = 0; i < N; i++) {
        cin >> cards[i] ;
    }

    int maxSum = 0;
    for (int first = 0; first < N - 2; first++) {
        for (int second = first + 1; second < N - 1; second++) {
            for (int third = second + 1; third < N; third++) {
                int sum = cards[first] + cards[second] + cards[third];
                if (sum <= target) {
                    maxSum = max(maxSum, sum);
                }
            }
        }
    }
    
    cout << maxSum << endl;
}
