string biggerIsGreater(string w) {
    int len = w.length(), idx = -1;
    for (int i = len - 2; i >= 0; i--) {
        if (w[i] < w[i+1]) {
            idx = i;
            break;
        }
    }
    if (idx < 0)    return "no answer";
    
    int nextIdx;
    for (int i = idx + 1; i < len; i++) {
        if (w[i] > w[idx] && w[i] <= w[idx+1]) {
            nextIdx = i;
        }
    }
    
    swap(w[idx], w[nextIdx]);
    sort(w.begin() + idx + 1, w.end());
    
    return w;
}
