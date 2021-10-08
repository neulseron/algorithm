#include <string>
#include <vector>
#include <iostream>
#include <set>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    set<int> endList;
    
    int releaseTurn = 0;
    while (releaseTurn < progresses.size()) {
        for (int i = 0; i < progresses.size(); i++) {
            progresses[i] += speeds[i];
            
            if (progresses[i] >= 100 & endList.find(i) == endList.end()) {  // 완료항목에 없으면 추가
                endList.insert(i);
            }
        }
        
        if (endList.find(releaseTurn) != endList.end()) {
            int releaseNum = 1;
            
            while (endList.find(releaseTurn+1) != endList.end()) {
                releaseNum++;
                releaseTurn++;
            }

            answer.push_back(releaseNum);
            releaseTurn++;
        }
    }
    
    return answer;
}
