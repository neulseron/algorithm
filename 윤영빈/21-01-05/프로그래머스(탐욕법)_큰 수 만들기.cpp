#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    
    int haveto = number.length() - k; // k만큼 제거하고 뽑혀야 할 문자 수
    int index = 0;
    while(haveto > 0)
    {
        int maxVal = 0;
        for (int i = index; i < number.length() - haveto + 1; i++) {
            if (number[i] - '0' > maxVal) {
                maxVal = number[i] - '0';
                index = i;
            }
        }
        answer += to_string(maxVal);
        haveto--;
        index++;
    }
    
    return answer;
}
