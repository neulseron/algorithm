#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    for (int i = 1; i < n + 1; i++) {
        int sum = 0, index = i;
        
        while (true) {
            sum += index;
            index++;
            
            if (sum == n) {
                answer++;
                break;
            } else if (sum > n) {
                break;
            }
        }
    }
    
    
    return answer;
}
