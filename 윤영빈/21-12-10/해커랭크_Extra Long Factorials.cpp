void multiply(vector<int>& result, int n, int& len)
{
    int carry = 0;
    for (int i = 0; i < len; i++) {
        int calc = result[i] * n + carry;
        result[i] = calc % 10;
        carry = calc / 10;
    }
    
    while (carry > 0) {
        result[len] = carry % 10;
        carry /= 10;
        len++;
    }
}

void extraLongFactorials(int n) {
    vector<int> result (300, 0);
    result[0] = 1;
    
    int len = 1;
    
    for (int i = 2; i <= n; i++) {
        multiply(result, i, len);
    }
    
    for (int i = len - 1; i >= 0; i--) {
        cout << result[i];
    }
}
