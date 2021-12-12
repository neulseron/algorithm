string organizingContainers(vector<vector<int>> container) {
    vector<int> totalEachContainer (container.size(), 0);
    vector<int> totalTypes (container.size(), 0);
    for (int i = 0; i < container.size(); i++) {
        for (int j = 0; j < container.size(); j++) {
            totalEachContainer[i] += container[i][j];
            totalTypes[i] += container[j][i];
        }
    }
    
    sort(totalEachContainer.begin(), totalEachContainer.end());
    sort(totalTypes.begin(), totalTypes.end());
    
    string answer = "ossible";
    for (int i = 0; i < container.size(); i++) {
        if (totalEachContainer[i] != totalTypes[i]) {
            answer = "Imp" + answer;
            return answer;
        }
    }
    answer = "P" + answer;
    
    return answer;
}
