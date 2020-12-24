#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    
    priority_queue<int, vector<int>, greater<int>> list;
    for (int i = 0; i < scoville.size(); i++)
        list.push(scoville[i]);
    
    while (1) {
        answer++;
        
        if (list.top() < K) {
            int tmp = list.top();
            list.pop();
            tmp += list.top() * 2;
            list.pop();
            list.push(tmp);
        }
        
        if (list.size() == 1 && list.top() < K)
            return -1;
        
        if (list.top() >= K)
            break;
    }
    
    return answer;
}
