#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    queue<int> list;
    for (int i = 0; i < progresses.size(); i++)
        list.push(i);
        
    while(list.size() > 1) {
        for (int i = list.front(); i < progresses.size(); i++) {
            progresses[i] += speeds[i];
        }
        
        int cnt = 0;
        for (int i = list.front(); progresses[i] >= 100 && list.size() >= 1; i++) {
            list.pop();
            cnt++;
        }
        
        if(cnt != 0)
            answer.push_back(cnt);
    }
    
    if(list.size() == 1)
        answer.push_back(1);

    return answer;
}
