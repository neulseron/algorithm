#include <iostream>
#include <vector>

using namespace std;

int N;

int main()
{
    cin >> N;
    vector<int> nums (N);
    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }

    vector<int> sum (nums);
    int mx = nums[0];
    for (int i = 1; i < N; i++) {
        sum[i] = max(nums[i], sum[i-1] + nums[i]);
        mx = max(mx, sum[i]);
    }

    cout << mx;
}
