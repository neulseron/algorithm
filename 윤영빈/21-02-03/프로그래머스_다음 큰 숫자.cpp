#include <string>
#include <vector>

using namespace std;

vector<int> tobinary(int x) {
    vector<int> tmp;

    while(x > 1) {
        tmp.push_back(x % 2);
        x = x / 2;
    }
    tmp.push_back(1);

    return tmp;
}

int cntOne(vector<int> a) {
    int cnt = 0;
    for (int i = 0; i < a.size(); i++)
        if (a[i] == 1)
            cnt++;
    return cnt;
}

int solution(int n) {
    vector<int> binary_n = tobinary(n); // 역순
    int nOne = cntOne(binary_n);

    for (int i = n + 1; ; i++) {
        vector<int> tmp = tobinary(i);
        if (nOne == cntOne(tmp))
            return i;
    }
}
