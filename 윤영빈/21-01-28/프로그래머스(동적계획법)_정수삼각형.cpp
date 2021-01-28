#include <string>
#include <vector>
#include <algorithm>

using namespace std;

const int MAX = 500;
vector<vector<int>> sum (MAX, vector<int> (MAX));

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    
    sum[0][0] = triangle[0][0];
    for (int x = 1; x < triangle.size(); x++) {
        for (int y = 0; y <= x; y++) {
            if (y == 0) 
                sum[x][y] = sum[x-1][y] + triangle[x][y];
            else if (y == x)
                sum[x][y] = sum[x-1][y-1] + triangle[x][y];
            else
                sum[x][y] = max(sum[x-1][y], sum[x-1][y-1]) + triangle[x][y];
            
            answer = max(answer, sum[x][y]);
        }
    }
    
    return answer;
}
