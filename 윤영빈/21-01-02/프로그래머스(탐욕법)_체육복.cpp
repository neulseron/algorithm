#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    
    vector<int> have (n, 0);
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < lost.size(); j++) 
            if (i == lost[j])  // 잃어버린 사람이면
                have[i-1] += (-1);
        for (int j = 0; j < reserve.size(); j++)
            if (i == reserve[j])
                have[i-1] += 1;
    }
    
    for (int i = 0; i < n; i++) {
        if (have[i] == -1 && have[i-1] == 1) {
            have[i-1] += (-1);
            have[i] += 1;
        } else if (have[i] == -1 && have[i+1] == 1) {
            have[i+1] += (-1);
            have[i] += 1;
        }
    }
    
    for (int i = 0; i < n; i++) {
        if (have[i] >= 0)
            answer++;
    }
    
    return answer;
}
