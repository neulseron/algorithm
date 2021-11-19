#include <iostream>
#include <vector>

using namespace std;

int N;
int answer = 0;
vector<int> col;

bool chkRow(int row)
{
    for (int i = 0; i < row; i++) {
        if (col[i] == col[row] || (row - i) == abs(col[row] - col[i]))
            return false;
    }

    return true;
}

void nqueen(int row)
{
    if (row == N) {
        answer++;
        return;
    } else {
        for (int i = 0; i < N; i++) {
            col[row] = i;

            if (chkRow(row))    
                nqueen(row+1);
        }
    }
}

int main()
{
    cin >> N;
    col.assign(N, 0);

    nqueen(0);

    cout << answer;
}
