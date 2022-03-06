#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int N;
    cin >> N;

    vector<long long> tiles (N+1);
    tiles[0] = 0;
    tiles[1] = 1;
    tiles[2] = 2;

    for (int i = 3; i <= N; i++) {    
        tiles[i] = ((tiles[i-2] % 15746) + (tiles[i-1] % 15746)) % 15746;
    }

    cout << tiles[N];
}
