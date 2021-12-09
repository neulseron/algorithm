int pickingNumbers(vector<int> a) {
    sort(a.begin(), a.end());
    
    map<int, int> m;
    for (int i = 0; i < a.size(); i++) {
        if (m.find(a[i]) == m.end()) {
            m[a[i]] = 1;
        } else {
            m[a[i]]++;
        }
    }
    
    vector<int> key;
    vector<int> val;
    for (auto iter : m) {
        key.push_back(iter.first);
        val.push_back(iter.second);
    }
    
    int len = *max_element(val.begin(), val.end());
    for (int i = 0; i < key.size(); i++) {
        if (key[i+1] - key[i] == 1) {
            len = max(len, val[i+1] + val[i]);
        }
    }
    
    return len;
}
