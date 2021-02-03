#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> arr) {
    sort(arr.begin(), arr.end(), greater<int>());
    for (int i = arr.at(0); ; i++) {
        int chk = 0;
        for (int j = 0; j < arr.size(); j++) {
            if (i % arr[j] == 0)
                chk++;
        }
        if (chk == arr.size())
            return i;
    }
}
