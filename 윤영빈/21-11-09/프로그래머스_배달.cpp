#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

int dijkstra(const vector<vector<pair<int, int>>>& graph, pair<int, int> start, const int& K)
{
    vector<int> distance (graph.size(), INT_MAX);
    distance[0] = 0;
    
    priority_queue<pair<int, int>> minDist;
    minDist.push(start);
    
    while (!minDist.empty()) {
        pair<int, int> currNode = minDist.top();
        minDist.pop();
        
        for (int i = 0; i < graph[currNode.first].size(); i++) {
            pair<int, int> nextNode = graph[currNode.first][i];
            int newDist = currNode.second + nextNode.second;

            if (distance[nextNode.first] > newDist) {
                minDist.push({nextNode.first, newDist});
                distance[nextNode.first] = newDist;
            }
        }
    }
    
    int cnt = 0;
    for (int i = 0; i < distance.size(); i++) {
        cout << "city : " << i << ", dist : " << distance[i] << "\n";
        if (distance[i] <= K) {
            cnt++;
        }
    }
    
    return cnt;
}

int solution(int N, vector<vector<int>> road, int K) {
    vector<vector<pair<int, int>>> graph (N);
    for (int i = 0; i < road.size(); i++) {
        graph[road[i][0] - 1].push_back(make_pair(road[i][1] - 1, road[i][2]));
        graph[road[i][1] - 1].push_back(make_pair(road[i][0] - 1, road[i][2]));
    }
    
    int answer = dijkstra(graph, {0, 0}, K);
    return answer;
}
