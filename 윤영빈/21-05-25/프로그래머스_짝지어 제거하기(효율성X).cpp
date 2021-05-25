#include <iostream>
#include <string>

using namespace std;

int solution(string s)
{
    int answer = -1;

    for (int i = 1;  i < s.length(); i++) {
        if (s[i-1] == s[i]) {
            s.replace(i-1, 2, "");
            i = 0;
        }
    }
    
    if (s.length() == 0)
        answer = 1;
    else answer = 0;

    return answer;
}
