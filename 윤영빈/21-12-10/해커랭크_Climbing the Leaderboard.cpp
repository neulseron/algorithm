vector<int> climbingLeaderboard(vector<int> ranked, vector<int> player) {
    vector<int> answer (player.size());
    
    int lastRank = 1;
    for (int i = ranked.size() - 1; i > 0; i--) {
        if (ranked[i-1] > ranked[i]) {
            lastRank++;
        }
    }
    lastRank++;
    
    int j = ranked.size() - 1;
    for (int i = 0; i < player.size(); i++) {
        while (player[i] >= ranked[j]) {
            if (lastRank == 1) {
                break;
            } else if (ranked[j] == ranked[j-1]) {
                j--;
            } else {
                j--;
                lastRank--;
            }
        }
        answer[i] = lastRank;
    }
    
    return answer;
}
