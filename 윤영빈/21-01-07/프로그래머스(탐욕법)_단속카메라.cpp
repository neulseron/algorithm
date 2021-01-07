#include <string> 
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 0;
    
    sort(routes.begin(), routes.end()); // 들어온 시간 빠른 순 정렬
    
    int out = routes[0][1];
    for (int i = 1; i < routes.size(); i++) {
        if (out < routes[i][0]) { // 나간 다음에 차 들어오면
            answer++;
            out = routes[i][1];
        }
        
        if (out > routes[i][1])
            out = routes[i][1];
    }
    
    return answer + 1;
}
