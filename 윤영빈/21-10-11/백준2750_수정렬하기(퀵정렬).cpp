#include <iostream>
#include <vector>

using namespace std;

auto split(vector<int>::iterator begin, vector<int>::iterator end) {
    int pivot = *begin;
    auto left = begin + 1;
    auto right = end;

    while (true) {
        while (*left <= pivot && distance(left, right) > 0) {
            left++;
        }

        while (*right > pivot && distance(left, right) > 0) {
            right--;
        }

        if (left == right)  break;
        else iter_swap(left, right);
    }

    if (pivot > *right) {
        iter_swap(begin, right);
    }

    return right;
}

void quickSort(vector<int>::iterator begin, vector<int>::iterator last)
{
    if (distance(begin, last) >= 1) {
        auto splitIter = split(begin, last);

        quickSort(begin, splitIter -1);
        quickSort(splitIter, last);
    }
}

int main()
{
    int N;
    cin >> N;

    vector<int> nums (N);
    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }

    quickSort(nums.begin(), nums.end()-1);

    for (int i = 0; i < N; i++) {
        cout << nums[i] << " ";
    }
}
