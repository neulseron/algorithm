#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(string word) {
    int answer = 0;
    
    int lenNum[5] = { 781, 156, 31, 6, 1 };
    map<char, int> vowel = { {'A', 0}, {'E', 1}, {'I', 2}, {'O', 3}, {'U', 4} };
    
    for (int i = 0; i < word.length(); i++) {
        answer += vowel[word[i]] * lenNum[i] + 1;
    }
    
    return answer;
}
