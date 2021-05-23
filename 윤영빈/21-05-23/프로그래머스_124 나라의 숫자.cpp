#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    int d = n;
    
    while (d != 0) {
        int r = d % 3;
        d = d / 3;
        
        if (r == 0) {
            r = 4;
            d -= 1;
        }
        
        answer = to_string(r) + answer;
    }
    
    return answer;
}
