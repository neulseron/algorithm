string encryption(string s) {
    vector<char> str;
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == ' ') continue;
        str.push_back(s[i]);
    }
    
    int L = str.size();
    int row = 1, col;
    while (row * row < L) { row++; }
    col = row--;
    if (col * row < L) row++;
    
    vector<vector<char>> encrypt (row, vector<char> (col, ' '));
    int idx = 0;
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            encrypt[i][j] = str[idx++];
        }
    }
    
    string answer = "";
    for (int j = 0; j < col; j++) {
        for (int i = 0; i < row; i++) {
            if ('a' <= encrypt[i][j] && encrypt[i][j] <= 'z') answer += encrypt[i][j];
        }
        
        if (answer.back() != 32)    answer += " ";
    }
    
    return answer;
}
