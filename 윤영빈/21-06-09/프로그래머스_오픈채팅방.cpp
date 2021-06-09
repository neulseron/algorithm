#include <string>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

vector<string> solution(vector<string> record) {
    map<string, string> idName;
    for (int i = 0; i < record.size(); i++) {
        istringstream ss(record[i]);
        string buffer;
        
        int index = 0;
        string id = "", name = "";
        while (getline(ss, buffer, ' ')) {
            if (index == 1) { id = buffer; }
            
            if (index == 2) { 
                name = buffer;
                idName[id] = name;
            }
            
            index++;
        }
    }
    
    
    vector<string> answer;
    for (int i = 0; i < record.size(); i++) {
        istringstream ss(record[i]);
        string buffer;
        
        int state = -1;
        while (getline(ss, buffer, ' ')) {
            if (buffer == "Enter") {
                state = 0; continue;
            } else if (buffer == "Leave") {
                state = 1; continue;
            }
            
            string str = "";
            if (state != -1) {
                str += idName[buffer];
                
                if (state == 0)
                    str += "님이 들어왔습니다.";
                else if (state == 1)
                    str += "님이 나갔습니다.";
                
                answer.push_back(str);
                break;
            }
        }
    }
    
    return answer;
}
