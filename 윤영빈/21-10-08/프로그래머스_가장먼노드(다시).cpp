#include <string>
#include <vector>
#include <set>
#include <queue>
#include <algorithm>

using namespace std;

int solution(int n, vector<vector<int>> edge) {
    vector<vector<int>> graph(n, vector<int>());
    for (int i = 0; i < edge.size(); i++) {
        graph[edge[i][0]-1].push_back(edge[i][1]-1);
        graph[edge[i][1]-1].push_back(edge[i][0]-1);
    }
    
    set<int> visited;   // 방문한 곳
    set<int> visitList; // 앞으로 방문할 곳
    queue<int> list;    // 지금 방문할 곳
    list.push(0);
    
    vector<int> distance(n, 0);
    distance[0] = -1;
    vector<int> parent(n);
    parent[0] = 0;
    
    int dist = 0;
    while (!list.empty())
    {
        int currNode = list.front();
        list.pop();
        
        if (visited.find(currNode) == visited.end()) {
            visited.insert(currNode);
            distance[currNode] = distance[parent[currNode]] + 1;
            
            for (int i = 0; i < graph[currNode].size(); i++) {
                int nextNode = graph[currNode][i];
                if (visitList.find(nextNode) == visitList.end()) {
                    list.push(nextNode);
                    parent[nextNode] = currNode;
                    visitList.insert(nextNode);
                }
            }
        }
    }
    
    
    int answer = 0;
    sort(distance.begin(), distance.end(), greater<int>());
    for (int i = 1; i < distance.size(); i++) {
        if (distance[0] == distance[i]) {
            answer++;
        } else {
            break;
        }
    }
    
    return answer + 1;
}
