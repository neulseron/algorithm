#include <iostream>

using namespace std;

int solution(int n, int a, int b)
{
    int answer = 0;
    
    while (true) {
        answer++;
        a = (a + 1) / 2;
        b = (b + 1) / 2;
        
        if (a / 2 == b / 2) {
            if ((a - b != 1) && (a - b != -1))
                break;
        }
    }

    return answer;
}
