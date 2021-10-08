#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <algorithm>
#include <set>

using namespace std;

int N, E, V;
vector<pair<int, int>> edges;

void DFS(const vector<vector<int>> graph)
{
    vector<int> visit;
    set<int> visitedList;

    stack<int> stk;
    stk.push(V-1);

    while (!stk.empty()) {
        int currNode = stk.top();
        stk.pop();

        if (visitedList.find(currNode) == visitedList.end()) {
            visitedList.insert(currNode);
            visit.push_back(currNode);

            for (int i = 0; i < graph[currNode].size(); i++) {
                if (find(visit.begin(), visit.end(), graph[currNode][i]) == visit.end()) {
                    stk.push(graph[currNode][i]);
                }
            }
        }
    }

    for (auto i : visit)
        cout << i+1 << " ";
    cout << endl;
}

void BFS(const vector<vector<int>> graph)
{
    vector<int> visit;
    set<int> visitedList;

    queue<int> q;
    q.push(V-1);

    while (!q.empty()) {
        int currNode = q.front();   
        q.pop();

        if (visitedList.find(currNode) == visitedList.end()) {
            visitedList.insert(currNode);
            visit.push_back(currNode);

            for (int i = 0; i < graph[currNode].size(); i++) {
                if (find(visit.begin(), visit.end(), graph[currNode][i]) == visit.end()) {
                    q.push(graph[currNode][i]);
                }
            }
        }
    }

    for (auto i : visit)
        cout << i+1 << " ";
}

int main()
{
    cin >> N >> E >> V;

    vector<vector<int>> graph (N);
    vector<pair<int, int>> edges (E);
    for (int i = 0; i < E; i++) {
        cin >> edges[i].first >> edges[i].second;
        edges[i].first--; edges[i].second--;

        graph[edges[i].first].push_back(edges[i].second);
        graph[edges[i].second].push_back(edges[i].first);
    }

    for (int i = 0; i < N; i++) 
        sort(graph[i].begin(), graph[i].end(), greater<int>());
    DFS(graph);

    for (int i = 0; i < N; i++) 
        sort(graph[i].begin(), graph[i].end());
    BFS(graph);
}
