#include <iostream>
#include <vector>

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

void unionSet(int a, int b)
{
    int rootA = findRoot(a);
    int rootB = findRoot(b);

    if (rootA == rootB)     return;

    if (nodes[rootA].rank > nodes[rootB].rank) {
        swap(rootA, rootB);
    }

    nodes[rootA].parent = nodes[rootB].parent;
    nodes[rootB].rank++;
}

int main()
{
    int N, E;
    cin >> N >> E;

    vector<pair<int, int>> edges (E);
    for (int i = 0; i < E; i++) {
        cin >> edges[i].first >> edges[i].second;
        edges[i].first--;
        edges[i].second--;
    }

    for (int i = 0; i < N; i++) {
        nodes.push_back(Node{i});
    }

    for (int i = 0; i < E; i++) {
        unionSet(edges[i].first, edges[i].second);
    }

    int answer = 0;
    int root = findRoot(nodes[0].id);
    for (int i = 1; i < N; i++) {
        if (root == findRoot(nodes[i].id)) {
            answer++;
        }
    }

    cout << answer << endl;
}
