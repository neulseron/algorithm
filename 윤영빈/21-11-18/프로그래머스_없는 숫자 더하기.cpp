#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers) {
    int sum = 0;
    for (int i = 0; i < 10; i++) {
        sum += i;
    }
    
    for (int i = 0; i < numbers.size(); i++) {
        sum -= numbers[i];
    }
    
    return sum;
}
