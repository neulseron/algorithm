#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    
    vector<int> student(3, 0);
    vector<vector<int>> ans = { { 1, 2, 3, 4, 5 },
                               { 2, 1, 2, 3, 2, 4, 2, 5 },
                               { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
    
    for (int i = 0; i < answers.size(); i++) {
        if (answers[i] == ans[0][i % 5])
            student[0]++;
        if (answers[i] == ans[1][i % 8])
            student[1]++;
        if (answers[i] == ans[2][i % 10])
            student[2]++;
    }
    
    int mx = max(student[0], max(student[1], student[2]));
    for (int i = 0; i < 3; i++) {
        if (student[i] == mx)
            answer.push_back(i + 1);
    }
    
    sort(answer.begin(), answer.begin());
    
    return answer;
}
