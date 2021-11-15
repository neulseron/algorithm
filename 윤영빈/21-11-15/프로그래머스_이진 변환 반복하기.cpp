#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    
    int cntZero = 0, cntConvert = 0;
    
    while (s.length() > 1) {
        int tmpZero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '0') tmpZero++;
        }

        int len = s.length() - tmpZero;
        cntZero += tmpZero;
        if (s.length() > 1) {
            s = "";
            while (len > 0) {
                s = to_string(len % 2) + s;
                len /= 2;
            }
        }
        
        cntConvert++;
    }
    
    answer.push_back(cntConvert);
    answer.push_back(cntZero);
    
    return answer;
}
