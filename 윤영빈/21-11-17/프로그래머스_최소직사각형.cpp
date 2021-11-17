#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> sizes) {
    for (int i = 0; i < sizes.size(); i++) {
        sort(sizes[i].begin(), sizes[i].end());
    }
    
    int maxW = 0, maxH = 0;
    for (int i = 0; i < sizes.size(); i++) {
        maxW = max(maxW, sizes[i][0]);
        maxH = max(maxH, sizes[i][1]);
    }
    
    return maxW * maxH;
}
