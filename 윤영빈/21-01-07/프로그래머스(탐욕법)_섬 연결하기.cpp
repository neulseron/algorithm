//*** Kruskal 알고리즘 + Union/Find ***
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp (vector<int> a, vector<int> b) {
        return a[2] < b[2];
}

int find (int a, vector<int>* c) {
    if ((*c)[a] == a)
        return a;
    else
        return find((*c)[a], c);
}

void uni (int a, int b, vector<int>* c) {
    int x = find(a, c);
    int y = find(b, c);
    
    (*c)[y] = x;
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    
    vector<int> connected (n);
    for (int i = 0; i < n; i++)
        connected[i] = i;
    
    sort(costs.begin(), costs.end(), cmp); // 건설비용 낮은순
    for (int i = 0; i < costs.size(); i++) {
        if (find(costs[i][0], &connected) !=
            find(costs[i][1], &connected)) {
            uni(costs[i][0], costs[i][1], &connected);
            answer += costs[i][2];
        }
    }
    
    return answer;
}
