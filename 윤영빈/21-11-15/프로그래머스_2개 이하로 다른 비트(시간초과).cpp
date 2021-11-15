#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;
    
    
    for (int i = 0; i < numbers.size(); i++) {
        if (numbers[i] % 2 == 0) {
            answer.push_back(numbers[i] + 1);
        } else {
            long long num1 = numbers[i], num2 = numbers[i] + 1;
            
            while (true) {
                long long sum = num1 ^ num2;
                int cnt = 0;

                while (sum > 0) {
                    if ((sum & 1LL) == 1) {
                        cnt++;

                        if (cnt > 2)
                            break;
                    }
                    sum = sum >> 1;
                }

                if (cnt <= 2) {
                    answer.push_back(num2);
                    break;
                } else {
                    num2++;
                }
            }
        }
    }
      
    return answer;
}
