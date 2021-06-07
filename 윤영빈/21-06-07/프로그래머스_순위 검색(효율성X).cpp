#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <sstream>

using namespace std;

vector<int> solution(vector<string> info, vector<string> query) {
    // 지원자 정리
    vector<vector<string>> applicant(info.size(), vector<string>(5, ""));
    for (int i = 0; i < info.size(); i++) {
        string str = info[i];
        istringstream ss(str);
        string stringBuffer;
        
        applicant[i].clear();
        while (getline(ss, stringBuffer, ' ')){
            applicant[i].push_back(stringBuffer);
        }
    }
    
    // 쿼리 정리
    vector<vector<string>> querySet(query.size(), vector<string>(5, ""));
    for (int i = 0; i < query.size(); i++) {
        string str = query[i];
        istringstream ss(str);
        string stringBuffer;
        
        querySet[i].clear();
        while (getline(ss, stringBuffer, ' ')){
            if (stringBuffer != "and")
                querySet[i].push_back(stringBuffer);
        }
    }
    
    // 해당자 찾기 (3중포문)
    vector<int> answer (query.size(), 0);
    for(int q = 0; q < querySet.size(); q++) { 
        vector<bool> chkQuery (info.size(), true);
        for (int c = 0; c < 4; c++) {
            for (int a = 0; a < applicant.size(); a++) {
                if (chkQuery[a] == true && (querySet[q][c] == applicant[a][c] || querySet[q][c] == "-")) {
                    chkQuery[a] = true;
                } else {
                    chkQuery[a] = false;
                }
            }
        }
        // c = 5
        for (int a = 0; a < applicant.size(); a++) {
            if (chkQuery[a] == true && (stoi(querySet[q][4]) <= stoi(applicant[a][4]) || querySet[q][4] == "-")) {
                chkQuery[a] = true;
            } else {
                chkQuery[a] = false;
            }
        }
        
        
        for (int i = 0; i < chkQuery.size(); i++) {
            if (chkQuery[i] == true) {
                answer[q]++;
            }
        }
    }
    
    return answer;
}
