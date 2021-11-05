#include <iostream>
#include <vector>

using namespace std;

int N;
vector<int> dataArr;
int mergeArr[1000000];

void Merge(int start, int last)
{
    int mid = (start + last) / 2;
    int left = start;
    int right = mid + 1;
    int k = start;

    while (left <= mid && right <= last) {
        if (dataArr[left] <= dataArr[right]) {
            mergeArr[k] = dataArr[left];
            left++;
            k++;
        } else {
            mergeArr[k] = dataArr[right];
            right++;
            k++;
        }
    }

    while (left <= mid) {
        mergeArr[k] = dataArr[left];
        left++;
        k++;
    }

    while (right <= last) {
        mergeArr[k] = dataArr[right];
        right++;
        k++;
    }

    for (int m = start; m <= last; m++) {
        dataArr[m] = mergeArr[m];
    }
}

void MergeSort(int start, int last)
{
    if (start < last) {
        int mid = (start + last) / 2;
        MergeSort(start, mid);
        MergeSort(mid + 1, last);
        Merge(start, last);
    }
}

int main()
{
    cin >> N;

    for (int i = 0; i < N; i++) {
        int tmp;
        cin >> tmp;
        dataArr.push_back(tmp);
    }
    
    if (N == 1) {
        cout << dataArr[0];
    } else {
        MergeSort(0, N-1);

        for (int i = 0; i < N; i++) {
            cout << mergeArr[i] << "\n";
        }
    }
}
