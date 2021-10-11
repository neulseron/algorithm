#include <iostream>

using namespace std;

int main()
{
    int N;
    cin >> N;

    int answer = 0;
    int num = 666, series = 0;
    while (true) {
        string target = to_string(num);

        for (int i = 0; i < target.length() - 2; i++) {
            if (target[i] == '6' && target[i+1] == '6' && target[i+2] == '6') {
                series++;

                if (series == N) {
                    answer = num;
                }
                
                break;
            }
        }
        
        num++;

        if (answer != 0)    break;
    }

    cout << answer;
}
