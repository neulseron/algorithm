#include <string>
#include <vector>
#include <set>

using namespace std;

struct Node
{
    int id;
    int rank;
    int parent;
    
    Node(int _id) : id(_id), rank(0), parent(_id) {}
};

vector<Node> nodes;

int findParent(int id)
{
    while (id != nodes[id].parent) {
        id = nodes[id].parent;
    }
    
    return id;
}

void unionSet(int a, int b)
{
    int rootA = findParent(a);
    int rootB = findParent(b);
    
    if (rootA == rootB)     return;
    
    if (nodes[rootA].rank > nodes[rootB].rank) {
        swap(rootA, rootB);
    }
    
    nodes[rootA].parent = nodes[rootB].parent;
    nodes[rootB].rank++;
}


int solution(int n, vector<vector<int>> computers) {
    for (int i = 0; i < n; i++) {
        nodes.push_back(Node{i});
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (computers[i][j] == 1) {
                unionSet(i, j);
            }
        }
    }
    
    set<int> parents;
    for (int i = 0; i < n; i++) {
        if (parents.find(findParent(i)) == parents.end()) {
            parents.insert(findParent(i));
        }
    }
    
    return parents.size();
}
