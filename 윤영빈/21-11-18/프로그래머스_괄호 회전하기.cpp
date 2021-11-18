#include <string>
#include <vector>
#include <deque>
#include <stack>
#include <iostream>
#include <map>

using namespace std;

int solution(string s) {
    int answer = 0;
    int X = s.length();
    
    map<char, char> b;
    b['['] = ']';
    b['{'] = '}';
    b['('] = ')';
    
    deque<char> dq;
    for (int i = 0; i < X; i++) {
        dq.push_back(s[i]);
    }
    
    stack<char> stk;
    for (int rot = 0; rot < X; rot++) {
        while(!stk.empty()) stk.pop();
        stk.push(dq.front());
        
        int popCnt = 0;
    
        for (int i = 1; i < X; i++) {
            if (!stk.empty() && dq[i] == b[stk.top()]) {
                stk.pop();
                popCnt++;
            } else {
                stk.push(dq[i]);
            }
        }
        
        if (stk.empty() && popCnt == X / 2)    answer++;
    
        int front = dq.front();
        dq.pop_front();
        dq.push_back(front);
    }
    
    
    return answer;
}
