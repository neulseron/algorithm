#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

struct cmp {
    bool operator()(vector<int> a, vector<int> b) {
        return a[1] > b[1]; // 오름차순
    }
};

int solution(vector<vector<int>> jobs) {
    int answer = 0;
    
    // 요청시간 빠른 순 정렬(0번째 원소 비교)
    sort(jobs.begin(), jobs.end());
    
    int time = 0;
    int cur_index = 0;
    int chk = 0;
    priority_queue<vector<int>, vector<vector<int>>, cmp> list;
    while (1) {
        // 현재 시간 이전에 도착한 작업 큐에 추가
        for (int i = cur_index; i < jobs.size() && jobs[i][0] <= time; i++) {
            list.push(jobs[i]);
            cur_index = i + 1;
        }
        
        // 하나도 없으면
        if (list.size() < 1) 
            time++;
        else {
            time += list.top()[1];
            answer += time - list.top()[0];
            chk++;
            if(chk == jobs.size()) // job 개수만큼 다 끝났으면
                break;
            list.pop();
        }
    }
    
    answer = answer / jobs.size();
    
    return answer;
}
