#include <string>
#include <vector>
#include <iostream>

using namespace std;

struct Node
{
    int id;
    int parent;
    int rank;
    
    Node(int _id) : id(_id), parent(_id), rank(0) {}
};

vector<Node> nodes;

int findRoot(int id)
{
    while (id != nodes[id].parent) {
        id = nodes[id].parent;
    }
    
    return id;
}

void unionNode(int aId, int bId)
{
    int rootA = findRoot(aId);
    int rootB = findRoot(bId);
    
    if (rootA == rootB) return;
    
    if (nodes[rootA].rank > nodes[rootB].rank) {
        swap(rootA, rootB);
    }
    
    nodes[rootA].parent = nodes[rootB].parent;
    nodes[rootB].rank++;
}


void initNodes()
{
    for (int i = 0; i < nodes.size(); i++) {
        nodes[i] = Node(i);
    }
}

int solution(int n, vector<vector<int>> wires) {
    int answer = 999;
    
    nodes.assign(n, Node(0));
    initNodes();
    
    int except = 0;
    while (except < wires.size()) {
        for (int i = 0; i < wires.size(); i++) {
            if (i == except) continue;

            unionNode(wires[i][0]-1, wires[i][1]-1);
        }
        
        int firstRootId = findRoot(nodes[0].id), firstRootCnt = 1, secondRootCnt = 0;
        for (int i = 1; i < n; i++) {
            int rootId = findRoot(nodes[i].id);
            if (rootId != firstRootId) secondRootCnt++;
            else firstRootCnt++;
        }
        
        answer = min(answer, abs(secondRootCnt - firstRootCnt));
        
        initNodes();
        except++;
    }
    
    return answer;
}
