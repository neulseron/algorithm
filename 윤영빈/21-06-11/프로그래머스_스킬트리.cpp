#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

bool isNeedOrder(char s, string skill)
{
    for (int i = 0; i < skill.length(); i++) {
        if (skill[i] == s) {
            return true;
        }
    }
    
    return false;
}

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    
    queue<char> order;
    for (int i = 0; i < skill_trees.size(); i++) {
        order = queue<char>();
        for (int i = 0; i < skill.length(); i++) {    // 큐 초기화
            order.push(skill[i]);
        }
        
        for (int j = 0; j < skill_trees[i].length(); j++) {
            if (isNeedOrder(skill_trees[i][j], skill)) {   // 서순 필요하면
                if (order.front() == skill_trees[i][j]) {
                    order.pop();
                } else  
                    break;
            }
            
            if (j == skill_trees[i].length() - 1 || order.empty()) {
                answer++;
                break;
            }
        }
    }
    
    return answer;
}
