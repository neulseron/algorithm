#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

int N;
vector<int> nums (N);

int minTotal = INT_MAX, maxTotal = -INT_MAX;

char op [4] = { '+', '-', '*', '/' };
int opCnt [4] = {0, };

void calc(int idx, int total)
{
    if (idx == N) {
        minTotal = min(minTotal, total);
        maxTotal = max(maxTotal, total);
        return;
    }

    for (int i = 0; i < 4; i++) {
        if (opCnt[i] > 0) {
            opCnt[i]--;

            switch (i) {
                case 0:
                    calc(idx + 1, total + nums[idx]);
                    break;
                case 1:
                    calc(idx + 1, total - nums[idx]);
                    break;
                case 2:
                    calc(idx + 1, total * nums[idx]);
                    break;
                case 3:
                    calc(idx + 1, total / nums[idx]);
                    break;
            }

            opCnt[i]++;
        }
    }
}

int main()
{
    cin >> N;

    nums.assign(N, 0);
    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }
    
    for (int i = 0; i < 4; i++) {
        cin >> opCnt[i];
    }

    calc(1, nums[0]);

    cout << maxTotal << "\n" << minTotal ;
}
