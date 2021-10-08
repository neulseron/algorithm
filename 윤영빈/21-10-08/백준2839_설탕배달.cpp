#include <iostream>

using namespace std;

int main()
{
    int N;
    cin >> N;

    int maxFive = N / 5;
    int leftWeight;
    
    int answer = 0;
    while (true) {
        leftWeight = N - maxFive * 5;

        if (maxFive == 0 && (leftWeight % 3) != 0) {
            answer = -1;
            break;            
        }

        if (leftWeight % 3 != 0) {
            maxFive--;
        } else {
            answer = maxFive + (leftWeight / 3);
            break;
        }
    }

    cout << answer << endl;
}
