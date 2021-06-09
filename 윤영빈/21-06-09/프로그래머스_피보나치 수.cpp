#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    int a = 0, b = 1, c;
    if (n == 0)
        answer = 0;
    else if (n == 1)
        answer = 1;
    else {
        for (int i = 2; i <= n; i++) {
            c = (a % 1234567) + (b % 1234567);
            a = b % 1234567;
            b = c % 1234567;
        }
        answer = c % 1234567;
    }
    
    return answer;
}
