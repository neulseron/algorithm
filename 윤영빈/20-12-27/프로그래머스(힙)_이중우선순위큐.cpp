#include <string>
#include <vector>
#include <deque>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer (2);
    deque<int> q;
    
    for (int i = 0; i < operations.size(); i++) {
        if (operations[i].substr(0, 1) == "I") { // 숫자 삽입
            int val = stoi(operations[i].substr(2));
            q.push_back(val);
            sort(q.begin(), q.end()); // 오름차순
        } else if (operations[i].substr(2, 1) == "-" && q.size() > 0) { // 최솟값 삭제
            q.pop_front();
            sort(q.begin(), q.end());
        } else if (q.size() > 0) { // 최댓값 삭제
            q.pop_back();
            sort(q.begin(), q.end());
        }
    }
    
    if (q.size() > 0) { // 안 비었으면 
        answer[0] = q.back();
        answer[1] = q.front();
    } else {
        answer[0] = 0;
        answer[1] = 0;
    }
    
    return answer;
}
