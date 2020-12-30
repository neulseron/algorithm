#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp (int a, int b) {
    return a > b; // 내림차순
}

int solution(vector<int> citations) {
    int answer = 0;
    
    sort(citations.begin(), citations.end(), cmp);
    
    for ( ;answer < citations.size(); answer++) {
        if (citations[answer] <= answer) {
            return answer;
        }    
    }
}
