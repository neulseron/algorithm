#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(string str1, string str2) {
    vector<string> set1, set2;
    
    for (int i = 0; i < str1.length() - 1; i++) {
        string mem = "";
        
        if ((int)str1[i] >= 65 && (int)str1[i] <= 90) {     // 앞글자 대문자
            mem = mem + str1[i];
        } else if ((int)str1[i] >= 97 && (int)str1[i] <= 122) { // 앞글자 소문자
            char tmp = str1[i] - 32;
            mem = mem + tmp;
        }
        
        if ((int)str1[i+1] >= 65 && (int)str1[i+1] <= 90) {     // 뒷글자 대문자
            mem = mem + str1[i+1];
        } else if ((int)str1[i+1] >= 97 && (int)str1[i+1] <= 122) { // 뒷글자 소문자
            char tmp = str1[i+1] - 32;
            mem = mem + tmp;
        }
        
        if (mem.length() == 2) {
            set1.push_back(mem);
        }
    }
    
    for (int i = 0; i < str2.length() - 1; i++) {
        string mem = "";
        if ((int)str2[i] >= 65 && (int)str2[i] <= 90) {     // 앞글자 대문자
            mem = mem + str2[i];
        } else if ((int)str2[i] >= 97 && (int)str2[i] <= 122) { // 앞글자 소문자
            char tmp = str2[i] - 32;
            mem = mem + tmp;
        }
        
        if ((int)str2[i+1] >= 65 && (int)str2[i+1] <= 90) {     // 뒷글자 대문자
            mem = mem + str2[i+1];
        } else if ((int)str2[i+1] >= 97 && (int)str2[i+1] <= 122) { // 뒷글자 소문자
            char tmp = str2[i+1] - 32;
            mem = mem + tmp;
        }
        
        if (mem.length() == 2) {
            set2.push_back(mem);            
        }
    }
    
    
    vector<string> lg(set1.size() >= set2.size() ? set1 : set2);
    sort(lg.begin(), lg.end());
    vector<string> st(set1.size() >= set2.size() ? set2 : set1);
    sort(st.begin(), st.end());
    
    int min = 0, st_index = 0;
    int lg_ori = lg.size();
    vector<bool> chkLg (lg_ori, false);
    while (st_index < st.size()) {
        for (int l = 0; l < lg_ori; l++) {
            if (lg[l] == st[st_index] && !chkLg[l]) {
                chkLg[l] = true;
                min++;
                break;
            }
            if (l == lg_ori - 1) {
                lg.push_back(st[st_index]);
            }
        }
        
        st_index++;
    }
    int max = lg.size();
    
    float j = 0;
    if (min == 0 && max == 0)
        j = 1;
    else 
        j = (float)min / (float)max;
    
    int answer = j * 65536.0;
    
    return answer;
}
