#include <iostream>
#include <vector>

using namespace std;

int N;

int main()
{
    string strA, strB;
    cin >> strA >> strB;

    vector<vector<int>> seqLen (strA.length()+1, vector<int> (strB.length()+1, 0));
    for (int a = 1; a <= strA.length(); a++) {
        for (int b = 1; b <= strB.length(); b++) {
            if (strA[a-1] == strB[b-1]) {
                seqLen[a][b] = seqLen[a-1][b-1] + 1;
            } else {
                seqLen[a][b] = max(seqLen[a][b-1], seqLen[a-1][b]);
            }
        }
    }

    cout << seqLen[strA.length()][strB.length()];
}
