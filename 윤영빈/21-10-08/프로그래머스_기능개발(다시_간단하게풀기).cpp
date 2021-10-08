#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    int releaseDay = 0;
    for (int i = 0; i < progresses.size(); i++) {
        int needDay = (99 - progresses[i]) / speeds[i] + 1;
        
        if (answer.empty() || releaseDay < needDay)     // 배포한 다음까지 시간이 필요한 경우
            answer.push_back(1);
        else
            ++answer.back();
        
        if (releaseDay < needDay)   
            releaseDay = needDay;
    }
    
    return answer;
}
