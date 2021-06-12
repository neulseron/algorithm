#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer (arr1.size(), vector<int>(arr2[0].size(), 0));
    
    for (int Arow = 0; Arow < arr1.size(); Arow++) {
        for (int Bcol = 0; Bcol < arr2[0].size(); Bcol++) {
            int sum = 0;
            for (int Acol = 0; Acol < arr1[0].size(); Acol++) {
                sum += arr1[Arow][Acol] * arr2[Acol][Bcol];
            }
            answer[Arow][Bcol] = sum;
        }
    }
    
    return answer;
}
