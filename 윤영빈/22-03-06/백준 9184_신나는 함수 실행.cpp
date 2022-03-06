#include <iostream>
#include <vector>

using namespace std;

int W[21][21][21] = { 0, };

int w(int a, int b, int c)
{
    if (a <= 0 || b <= 0 || c <= 0)    return 1;
    if (a > 20 || b > 20 || c > 20)    return w(20, 20, 20);

    if (W[a][b][c] != 0)    return W[a][b][c];

    if (a < b && b < c)    
        W[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
    else    
        W[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);

    return W[a][b][c];
}

int main()
{
    int a, b, c;
    while (true) {
        cin >> a >> b >> c;
        if (a == -1 && b == -1 && c == -1)  break;

        printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
    }
}
