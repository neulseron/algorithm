int nonDivisibleSubset(int k, vector<int> s) {
    vector<int> remains (k, 0);
    for (int i = 0; i < s.size(); i++) {
        int r = s[i] % k;
        remains[r]++;
    }
    
    int len = 0;
    if (remains[0] > 0) len++;
    
    for (int i = 1; i * 2 <= k; i++) {
        if (i * 2 == k && remains[i] > 0) {
            len++;
        } else {
            len += max(remains[i], remains[k-i]);
        }
    }
    
    return len;
}
