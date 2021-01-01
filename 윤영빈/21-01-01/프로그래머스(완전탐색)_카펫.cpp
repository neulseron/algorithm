#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer (2);
    int y_w = 0, y_h = 0;
    
    for (int i = 1; i * i <= yellow; i++) {
        if (yellow % i == 0) {
            y_h = i;
            y_w = yellow / y_h;
            if (brown == 2*y_w + 2*y_h + 4) {
                answer[0] = y_w + 2;
                answer[1] = y_h + 2;
            }
        }
    }
    
    return answer;
}
