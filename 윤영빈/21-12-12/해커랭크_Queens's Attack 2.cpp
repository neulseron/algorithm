int queensAttack(int n, int k, int r_q, int c_q, vector<vector<int>> obstacles) {
    int right = n+1, left = 0;
    int up = 0, down = n+1;
    int leftUp = 0, rightDown = n+1;
    int rightUp = 0, leftDown = n+1;
    
    for (int i = 0; i < obstacles.size(); i++) {
        if (obstacles[i][1] == c_q) {
            if (obstacles[i][0] < r_q) {
                up = max(up, obstacles[i][0]);
            } else {
                down = min(down, obstacles[i][0]);
            }
        } else if (obstacles[i][0] == r_q) {
            if (obstacles[i][1] < c_q) {
                left = max(left, obstacles[i][1]);
            } else {
                right = min(right, obstacles[i][1]);
            }
        }
        
        else if (obstacles[i][1]- obstacles[i][0] == c_q - r_q) {
            if (obstacles[i][0] < r_q) {
                leftUp = max(leftUp, obstacles[i][0]);
            } else {
                rightDown = min(rightDown, obstacles[i][0]);
            }
        } else if (obstacles[i][1] - c_q == -(obstacles[i][0] - r_q)) {
            if (obstacles[i][0] < r_q) {
                rightUp = max(rightUp, obstacles[i][0]);
            } else {
                leftDown = min(leftDown, obstacles[i][0]);
            }
        }
    }
    
    int answer = 0;
    
    answer += (right - c_q - 1) + (c_q - left - 1);
    answer += (down - r_q - 1) + (r_q - up - 1);
    
    answer += min(c_q - 1, r_q - leftUp - 1) + min(n - c_q, rightDown - r_q - 1);
    answer += min(n - c_q, r_q - rightUp - 1) + min(c_q - 1, leftDown - r_q - 1);
    
    return answer;
}
