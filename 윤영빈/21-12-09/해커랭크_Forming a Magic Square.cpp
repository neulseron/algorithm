bool chkSumEqual(const vector<int>& nums)
{
    int sum = nums[0] + nums[1] + nums[2];
    if (sum != (nums[3] + nums[4] + nums[5])) return false;
    if (sum != (nums[6] + nums[7] + nums[8])) return false;
    
    if (sum != (nums[0] + nums[3] + nums[6])) return false;
    if (sum != (nums[1] + nums[4] + nums[7])) return false;
    if (sum != (nums[2] + nums[5] + nums[8])) return false;
    
    if (sum != (nums[0] + nums[4] + nums[8])) return false;
    if (sum != (nums[2] + nums[4] + nums[6])) return false;
    
    return true;
}

int formingMagicSquare(vector<vector<int>> s) {
    vector<int> nums (9);
    for (int i = 0; i < 9; i++) nums[i] = i+1;
    
    int cost = 99999;
    do {
        if (chkSumEqual(nums)) {
            int diff = 0;
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    diff += abs(nums[j + 3 * i] - s[i][j]);
                }
            }
            
            cost = min(cost, diff);
        }
    } while (next_permutation(nums.begin(), nums.end()));
    
    return cost;
}
