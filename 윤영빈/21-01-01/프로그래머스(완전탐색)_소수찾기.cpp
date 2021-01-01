#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(string a, string b) {
    return a > b;
}

bool isIncluded(int n, string s) {
    string str_n = to_string(n);
    for (int i = 0; i < str_n.size(); i++) {
        bool chk = false;
        for (int j = 0; j < s.size(); j++) {
            if (str_n[i] == s[j]) {
                chk = true;
                str_n[i] = ' ';
                s[j] = ' ';
                break;
            }
        }
        if (!chk)
            return false;
    }
    return true;
}

bool chkPrime(int a) {
    if (a == 1)
        return false;
    else if (a == 2)
        return true;
    else {
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0)
                return false;
        }
    }
    
    return true;
}

int solution(string numbers) {
    int answer = 0;
    
    sort(numbers.begin(), numbers.end(), greater<int>());
    int max_num = stoi(numbers);
    
    for (int i = 1; i <= max_num; i++) {
        if (isIncluded(i, numbers) && chkPrime(i)) {
            answer++;
        }
    }
    
    return answer;
}
