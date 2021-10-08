#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    
    priority_queue<int, vector<int>> prior;
    queue<pair<int, bool>> waitingList;
    for (int i = 0; i < priorities.size(); i++) {
        prior.push(priorities[i]);
        
        if (i == location)
            waitingList.push({priorities[i], true});
        else
            waitingList.push({priorities[i], false});
    }
    
    while (true) {
        pair<int, int> turn = waitingList.front();
        waitingList.pop();
        
        if (turn.first != prior.top()) {
            waitingList.push(turn);
        } else {
            answer++;
            
            if (turn.second)
                break;
            else
                prior.pop();
        }
    }
    
    return answer;
}
