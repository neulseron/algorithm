#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

// 가장 많이 재생된 장르 순서
bool compare(pair<string, int> a, pair<string, int> b) {
    return a.second > b.second;
}

// 장르 내에서 많이 재생된 순서 (재생수, 곡번호)
bool compare_genres(pair<int, int> a, pair<int, int> b) {
    if (a.first == b.first) // 재생수 같으면
        return a.second < b.second;
    return a.first > b.first;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    
    // 장르별 총 재생수 / 장르,(재생수,곡번호)
    map<string, int> m_total;
    map<string, vector<pair<int, int>>> m_info;
    for(int i = 0; i < genres.size(); i++) { 
        m_total[genres[i]] += plays[i];
        m_info[genres[i]].push_back(make_pair(plays[i], i));
    }
    
    // 총 재생수 높은순 정렬
    vector<pair<string, int>> v_total;
    for(auto iter = m_total.begin(); iter != m_total.end(); iter++) {
        v_total.push_back(make_pair(iter->first, iter->second));
    }
    sort(v_total.begin(), v_total.end(), compare);
    // 재생수 높은순 정렬
    for(auto &i : m_info) {
        sort(i.second.begin(), i.second.end(), compare_genres);
    }
      
    // 두개까지
    for(int i = 0; i < v_total.size(); i++) {
        string name = v_total[i].first;
        for(int j = 0; (j < m_info[name].size()) && (j < 2); j++) {
            answer.push_back(m_info[name][j].second);
        }
    }
    
    return answer;
}
