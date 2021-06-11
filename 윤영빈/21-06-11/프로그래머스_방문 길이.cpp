#include <string>
#include <vector>
#include <map>

using namespace std;

vector<pair<int, int>> dir { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };   // UDRL

int solution(string dirs) {
    int answer = 0;
    map<string, vector<string>> isVisit;    // key : 출발좌표, val : 도착좌표
    
    int curX = 0, curY = 0;
    string curCoor = "00";
    for (int i = 0; i < dirs.length(); i++) {
        int d = dirs[i] == 'U' ? 0 : (dirs[i] == 'D' ? 1 : (dirs[i] == 'R' ? 2 : 3));
        int nextX = curX + dir[d].first;
        int nextY = curY + dir[d].second;
        string nextCoor = to_string(nextX) + to_string(nextY);
        
        if (nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) continue;
        
        if (isVisit.count(curCoor)) {   // 해당 키가 존재한다면
            vector<string> mapVal (isVisit[curCoor]);
            for (int j = 0; j < mapVal.size(); j++) {
                if (mapVal[j] == nextCoor) {    // 방문 했던 곳이면
                    break;
                }
                
                if (j == mapVal.size() - 1) {
                    isVisit[curCoor].push_back(nextCoor);
                    isVisit[nextCoor].push_back(curCoor);
                    answer++;
                }
            }
        } else {    // 해당 키가 존재하지 않으면
            isVisit[curCoor].push_back(nextCoor);
            isVisit[nextCoor].push_back(curCoor);
            answer++;
        }
        
        curX = nextX;
        curY = nextY;
        curCoor = to_string(curX) + to_string(curY);
    }
    
    
    return answer;
}
