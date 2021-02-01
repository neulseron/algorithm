#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> edge) {
    int answer = 1;
    
    vector<vector<int>> graph (n + 1);
    for (int i = 0; i < edge.size(); i++) {
        graph[edge[i][0]].push_back(edge[i][1]);
        graph[edge[i][1]].push_back(edge[i][0]);
    }
   
    vector<int> distance (n+1, 0);
    vector<bool> visit(n+1, false);
    queue<int> list;
    list.push(1);
    visit[1] = true;
    
    while (!list.empty()) {
        int curr = list.front();
        list.pop();
        
        for (int i = 0; i < graph[curr].size(); i++) {
            int next = graph[curr][i];
            if (!visit[next]) {
                list.push(next);
                visit[next] = true;
                distance[next] = distance[curr] + 1;
            }
        }
    }
    
    sort(distance.begin(), distance.end(), greater<int>());
    for (int i = 1; i < distance.size(); i++) {
        if (distance[i] != distance[0])
            return answer;
        else answer++;
    }
}
