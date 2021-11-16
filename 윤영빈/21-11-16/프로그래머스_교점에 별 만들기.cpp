#include <string>
#include <vector>
#include <iostream>
#include <climits>

using namespace std;

struct lineData {
    long long A;
    long long B;
    long long E;
};

vector<pair<long long, long long>> points;

long long minX = LLONG_MAX, maxX = LLONG_MIN;
long long minY = LLONG_MAX, maxY = LLONG_MIN;

void calcPoint(lineData a, lineData b)
{
    long long numX = (a.B * b.E) - (a.E * b.B);
    long long denoX = (a.A * b.B) - (a.B * b.A);
    
    long long numY = (a.E * b.A) - (a.A * b.E);
    long long denoY = (a.A * b.B) - (a.B * b.A);
    
    if (denoX != 0 && denoY != 0 && (numX % denoX) == 0 && (numY % denoY) == 0) {
        points.push_back({(numX / denoX), (numY / denoY)});
        
        minX = min(minX, numX / denoX);
        minY = min(minY, numY / denoY);
        
        maxX = max(maxX, numX / denoX);
        maxY = max(maxY, numY / denoY);
    }
}

vector<string> solution(vector<vector<int>> line) {
    vector<lineData> lines (line.size());
    for (int i = 0; i < lines.size(); i++) {
        lines[i] = { (long long)line[i][0], (long long)line[i][1], (long long)line[i][2] };
    }
    
    for (int i = 0; i < lines.size() - 1; i++) {
        for (int j = i + 1; j < lines.size(); j++) {
            calcPoint(lines.at(i), lines.at(j));
        }
    }

    string row = string(maxX - minX + 1, '.');
    vector<string> answer (maxY - minY + 1, row);
    
    for (pair<long long, long long> p : points) {
        answer[abs(p.second - maxY)][abs(p.first - minX)] = '*';
    }
    
    return answer;
}
