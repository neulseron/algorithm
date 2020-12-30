#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp (string a, string b) {
    return a + b > b + a; // 내림차순
}

string solution(vector<int> numbers) {
    string answer = "";

    vector<string> num;
    for (int i = 0; i < numbers.size(); i++)
        num.push_back(to_string(numbers[i]));
    sort(num.begin(), num.end(), cmp);
    
    if (num.front() == "0") // [0, 0, 0, 0, 0] 일때
        return "0";
    
    for (int i = 0; i < num.size(); i++)
        answer += num[i];
    
    return answer;
}
