#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    
    priority_queue<int, vector<int>, greater<int>> foods;
    for (int i = 0; i < scoville.size(); i++) {
        foods.push(scoville[i]);
    }
    
    while (foods.size() >= 2 && foods.top() < K) {
        int first = foods.top();    foods.pop();
        int second = foods.top();    foods.pop();
        
        foods.push(first + (second * 2));
        if (foods.size() < 2 && foods.top() < K)    return -1;
        
        answer++;
    }
    
    return answer;
}
