#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

string solution(string s) {
    string answer = "";
    vector<int> num;
    
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == ' ') {
            continue;
        } else if (s[i] == '-') {
            string n = "";
            i++;
            while ('0' <= s[i] && s[i] <= '9') {
                n += s[i];
                i++;
            } 
            num.push_back(stoi(n) * (-1));
        } else {
            string n = "";
            while ('0' <= s[i] && s[i] <= '9') {
                n += s[i];
                i++;
            } 
            num.push_back(stoi(n));
        }
    }
    
    sort(num.begin(), num.end());
    answer += to_string(num.front());
    answer += " ";
    answer += to_string(num.back());
    
    return answer;
}
