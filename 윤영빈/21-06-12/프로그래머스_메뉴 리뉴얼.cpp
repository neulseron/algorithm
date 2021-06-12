#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>

using namespace std;

map<int, int> lenMax;    // 코스 길이 별 최대 주문 횟수
map<string, int> menuList;

void makeSet(string menu, int index, int courseLen, string set)
{
    if (set.length() == courseLen) {
        if (menuList.count(set)) {  // 이미 존재하면
            menuList[set]++;
            lenMax[courseLen] = lenMax[courseLen] >= menuList[set] ? lenMax[courseLen] : menuList[set];
        } else {
            menuList[set] = 1;
            
            if (!lenMax.count(courseLen)) { // 해당 길이의 최대값이 존재하지 않을때
                lenMax[courseLen] = 1;
            }
        }
        
        return;
    }
    
    for (int i = index; i < menu.length(); i++) {
        set.push_back(menu[i]);
        makeSet(menu, i + 1, courseLen, set);
        set.pop_back();
    }
}

vector<string> solution(vector<string> orders, vector<int> course) {
    for (int i = 0; i < orders.size(); i++) {   // 손님 주문
        sort(orders[i].begin(), orders[i].end());
        for (int k = 0; k < course.size(); k++) {   // 코스 개수
            makeSet(orders[i], 0, course[k], "");
        }
    }
    
    vector<string> answer;
    for (auto it1 : lenMax) {
        int len = it1.first;    // 코스 길이
        int cnt = it1.second;   // 주문 횟수
        for (auto it2 : menuList) {
            if (it2.first.length() == len && it2.second > 1 && it2.second == cnt) {
                answer.push_back(it2.first);
            }
        }
    }
    
    sort(answer.begin(), answer.end());
    return answer;
}
