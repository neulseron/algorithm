#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer (2, 0);
    
    map<string, int> chkWords;
    for (int i = 0; i < words.size(); i++)
        chkWords[words[i]] = 0;
    
    int who = 0, turn = 0;
    char last = '-';
    for (int i = 0; i < words.size(); i++) {
        who = i % n; 
        turn = i / n;
        
        if (last == '-') {
            last = words[i].back();
        } else if (words[i].front() != last) { // 끝말이 이어지지 않는 경우
            answer[0] = who + 1;
            answer[1] = turn + 1;
            return answer;
        }
        
        chkWords[words[i]]++;
        
        if (chkWords[words[i]] > 1) {   // 이미 말했던 단어 일 경우
            answer[0] = who + 1;
            answer[1] = turn + 1;
            return answer;
        }
        
        last = words[i].back();
    }
    
    return answer;
}
