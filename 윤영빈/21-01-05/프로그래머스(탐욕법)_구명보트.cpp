#include <string>
#include <vector>
#include <algorithm>
#include <deque>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    deque<int> sortlist (people.size());
    
    sort(people.begin(), people.end(), greater<int>());
    sortlist.assign(people.begin(), people.end());
    
    for (int i = 0; sortlist.size() > 1; i++) {
        if (sortlist.front() + sortlist.back() <= limit) {
            answer++;
            sortlist.pop_front();
            sortlist.pop_back();
        } else {
            answer++;
            sortlist.pop_front();
        }
    }
    
    if (sortlist.size() == 1)
        answer++;
    
    return answer;
}
