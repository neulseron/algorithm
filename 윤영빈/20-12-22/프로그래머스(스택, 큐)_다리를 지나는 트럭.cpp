#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int cur_weight = 0;
    
    queue<int> wait;
    vector<pair<int, int>> ing; // 트럭번호, 건너는 시간
    for (int i = 0; i < truck_weights.size(); i++) {
        wait.push(i);
    }
    
    while (1) {
        answer++;
        
        if (wait.size() > 0 && (cur_weight + truck_weights[wait.front()]) <= weight) {
 // 지나갈 수 있으면 리스트에 추가
            cur_weight += truck_weights[wait.front()];
            ing.push_back(make_pair(wait.front(), 0));
            wait.pop();
        }
    
        // 리스트에 들어있는 트럭 시간 경과
        for (int i = 0; i < ing.size(); i++)
            ing[i].second++;  
        
        // 앞차 다리 다 건넜는지
        if (ing[0].second >= bridge_length) {
            cur_weight -= truck_weights[ing[0].first];
            ing.erase(ing.begin());
        }
        
        if (wait.size() == 0 && ing.size() == 0)
            break;
    }
    
    return answer + 1;
}
