#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <sstream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> info, vector<string> query) {
    // 지원자 정리
    map<string, vector<int>> infoMap;
    for (int i = 0; i < info.size(); i++) {
        istringstream ss(info[i]);
        string stringBuffer;
        
        int index = 0, score;
        vector<vector<string>> val (4, vector<string> (2, "-"));
        while (getline(ss, stringBuffer, ' ')){
            if (index < 4) {
                val[index++][0] = stringBuffer;
            } else {
                score = stoi(stringBuffer);
            }
        }
        
        for (int lang = 0; lang < 2; lang++) {
            string l, g, c, f;
            l = val[0][lang];
            for (int group = 0; group < 2; group++) {
                g = val[1][group];
                for (int career = 0; career < 2; career++) {
                    c = val[2][career];
                    for (int food = 0; food < 2; food ++) {
                        f = val[3][food];
                        infoMap[l + g + c + f].push_back(score);
                    }
                }
            }
        }
    }
    
    // 점수 정렬
    //for (auto iter : infoMap) {
        //sort(iter.second.begin(), iter.second.end());
    //}
    for(auto itr = infoMap.begin(); itr != infoMap.end(); itr++){
        sort(itr->second.begin(), itr->second.end());
    }
    
    // 쿼리 정리
    vector<int> answer (query.size(), 0);
    for (int i = 0; i < query.size(); i++) {
        istringstream ss(query[i]);
        string stringBuffer;
        
        int index = 0, score;
        string queryCon = "";
        while (getline(ss, stringBuffer, ' ')){
            if (stringBuffer == "and")  continue;
            
            if (index++ < 4) {
                queryCon = queryCon + stringBuffer;
            } else {
                score = stoi(stringBuffer);
            }
        }
        
        // 해당자 찾기 (큐)
        auto lower = lower_bound(infoMap[queryCon].begin(), infoMap[queryCon].end(), score);
        int indexLower = lower - infoMap[queryCon].begin();
        answer[i] = infoMap[queryCon].size() - indexLower;
    }
    
    return answer;
}
