using namespace std;

long long gcd(int a, int b) {
    while (b != 0) {
        int r = a % b;
        a = b;
        b = r;
    }
    return (long long)a;
}

long long solution(int w,int h) {
    long long answer = 1;
    
    long long broken = (long long)w + (long long)h - gcd(w, h);
    answer = (long long)w * (long long)h - broken;
    
    return answer;
}
