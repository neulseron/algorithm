int birthdayCakeCandles(vector<int> candles) {
    sort(candles.begin(), candles.end(), greater<int>());
    int maxVal = candles.at(0);
    
    int idx = 1;
    while (candles[idx] == maxVal) {
        idx++;
    }
    
    return idx;
}
