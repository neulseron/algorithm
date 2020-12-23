#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    
    queue<int> list;
    for (int i = 0; i < priorities.size(); i++)
        list.push(i);
    
    priority_queue<int> s_prior;
    for (int i = 0; i < priorities.size(); i++)
        s_prior.push(priorities[i]);
    
    while (1) {
        // 가장 높은 우선 순위이면
        if (priorities[list.front()] == s_prior.top()) {
            answer++;
            
            if (list.front() == location)
                return answer;
            
            list.pop();
            s_prior.pop();
        }
        else {
            int tmp = list.front();
            list.pop();
            list.push(tmp);
        }
    }
}
