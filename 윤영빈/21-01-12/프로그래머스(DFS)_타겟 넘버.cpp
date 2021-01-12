#include <string>
#include <vector>

using namespace std;

int answer = 0;

void dfs (int v, int id, vector<int> n, int t) {
    if (id == n.size()) {
        if (v == t)
            answer++;
        return;
    }
    
    dfs(v + n[id], id + 1, n, t);
    dfs(v - n[id], id + 1, n, t);
}

int solution(vector<int> numbers, int target) {
    int index = 0;
    
    dfs(0, index, numbers, target);
    
    return answer;
}
