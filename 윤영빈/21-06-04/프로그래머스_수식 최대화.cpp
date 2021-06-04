#include <string>
#include <vector>

using namespace std;

vector<vector<string>> prior = { { "+", "*", "-" }, { "+", "-", "*" }, { "*", "+", "-" }, 
                             { "*", "-", "+" }, { "-", "+", "*" }, { "-", "*", "+" } };

long long solution(string expression) {
    long long answer = 0;
    
    // ** 연산자, 피연산자 구분
    vector<string> splitExpression;
    string mem = "";
    mem += expression[0];
    for (int i = 1; i < expression.length(); i++) {
        if ((int)expression[i] >= 48 && (int)expression[i] <= 57) {
            mem = mem + expression[i];
        } else {
            splitExpression.push_back(mem);
            mem = "";
            
            string tmp = "";
            tmp += expression[i];
            splitExpression.push_back(tmp);
        }
    }
    splitExpression.push_back(mem);
    
    
    // ** 우선순위
    for (int i = 0; i < 6; i++) {
        vector<string> exp(splitExpression);
        long long result = 0;
        for (int j = 0; j < 3; j++) {
            result = 0;
            for (int k = 1; k < exp.size(); k = k+2) {
                if (exp[k] == prior[i][j]) {
                    if (prior[i][j] == "+") {
                        result = stoll(exp[k-1]) + stoll(exp[k+1]);
                    } else if (prior[i][j] == "*") {
                        result = stoll(exp[k-1]) * stoll(exp[k+1]);
                    } else if (prior[i][j] == "-") {
                        result = stoll(exp[k-1]) - stoll(exp[k+1]);
                    }
                    
                    exp.erase(exp.begin() + (k-1), exp.begin() + k);
                    exp.erase(exp.begin() + (k-1), exp.begin() + k);
                    exp.erase(exp.begin() + (k-1), exp.begin() + k);
                    
                    exp.insert(exp.begin() + (k-1), to_string(result));
                    
                    k = -1;
                }
            }
        }
        result = result < 0 ? result * (-1) : result;
        answer = result > answer ? result : answer;
    }
    
    return answer;
}
