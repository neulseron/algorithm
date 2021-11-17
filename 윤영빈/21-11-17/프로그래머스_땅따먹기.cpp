#include <iostream>
#include <vector>

using namespace std;

int solution(vector<vector<int>> land)
{
    vector<vector<int>> score (land.size(), vector<int> (4, 0));
    for (int j = 0; j < 4; j++) {
        score[0][j] = land[0][j];
    }
    
    for (int i = 1; i < score.size(); i++) {
        score[i][0] = land[i][0] + max(score[i-1][1], max(score[i-1][2], score[i-1][3]));
        score[i][1] = land[i][1] + max(score[i-1][0], max(score[i-1][2], score[i-1][3]));
        score[i][2] = land[i][2] + max(score[i-1][0], max(score[i-1][1], score[i-1][3]));
        score[i][3] = land[i][3] + max(score[i-1][0], max(score[i-1][2], score[i-1][1]));
    }

    int maxScore = 0;
    for (int j = 0; j < 4; j++) {
        maxScore = max(maxScore, score[score.size() - 1][j]);
    }
    
    return maxScore;
}
