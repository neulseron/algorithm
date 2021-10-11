#include <iostream>
#include <stack>
#include <unordered_map>

using namespace std;

int main()
{
    int N;
    cin >> N;

    int answer = 0;

    for (int i = 0; i < N; i++) {
        int sum = i, div = i;

        while (div != 0) {
            sum += div % 10;
            div /= 10;
        }

        if (sum == N) {
            answer = i;
            break;
        }
    }

    cout << answer;
}
