#include <string>
#include <vector>

using namespace std;

int answer = 0;
const int MAX = 50;
vector<bool> visit (MAX, false);

bool chkDiff(string a, string b) {
    int cnt = 0;
    
    for (int i = 0; i < a.length(); i++) {
        if (a[i] != b[i])
            cnt++;
    }
    
    if (cnt == 1)
        return true;
    
    return false;
}

void dfs(string curr, string target, vector<string> words, int cnt) {
    for (int i = 0; i < words.size(); i++) {
        if (chkDiff(curr, words[i])) {
            if (words[i] == target) {
                answer = cnt + 1;
                return;
            }
            
            if (!visit[i]) {
                visit[i] = true;
                dfs(words[i], target, words, cnt + 1);
            }
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    dfs(begin, target, words, 0);
    
    return answer;
}
