#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> answer;

bool chkUsed(vector<bool>& used) {
    for (int i = 0; i < used.size(); i++) {
        if (!used[i])
            return false;
    }
    
    return true;
}

bool dfs(string departure, vector<vector<string>> tickets, vector<bool>& used, vector<string>& tmp) {
    tmp.push_back(departure);
    
    if (chkUsed(used)) {
        answer  = tmp;
        return true;
    }
    
    for (int i = 0; i < tickets.size(); i++) {
        if (tickets[i][0] == departure && !used[i]) {
            used[i] = true;
        
            if(dfs(tickets[i][1], tickets, used, tmp)) {
                return true;
            }
            
            used[i] = false;
        }
    }
    
    tmp.pop_back();
    
    return false;
}

vector<string> solution(vector<vector<string>> tickets) {
    vector<bool> used (tickets.size(), false); 
    vector<string> tmp;
    
    sort(tickets.begin(), tickets.end());
    dfs("ICN", tickets, used, tmp);
    
    return answer;
}
