#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(string s) 
{
    string answerStr = "";
    int answer = 0;
    
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == 'o') {
            i += 2;
            answerStr += "1";
        } else if (s[i] == 't') {
            if (s[i+1] == 'w') {
                i += 2;
                answerStr += "2";
            } else {
                i += 4;
                answerStr += "3";
            }
        } else if (s[i] == 'f') {
            if (s[i+1] == 'o') {
                i += 3;
                answerStr += "4";
            } else {
                i += 3;
                answerStr += "5";
            }
        } else if (s[i] == 's') {
            if (s[i+1] == 'i') {
                i += 2;
                answerStr += "6";
            } else {
                i += 4;
                answerStr += "7";
            }
        } else if (s[i] == 'e') {
            i += 4;
            answerStr += "8";
        } else if (s[i] == 'n') {
            i += 3;
            answerStr += "9";
        } else if (s[i] == 'z') {
            i += 3;
            answerStr += "0";
        } else
            answerStr += s[i];
    }
    
    answer = stoi(answerStr);
    
    return answer;
}
