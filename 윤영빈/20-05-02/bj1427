#include <iostream>
#include <cstring>
using namespace std;

int main()
{
    char num[10] = "";
    cin>>num;

    int len = strlen(num);

    for(int i = 0; i < len-1; i++)
    {
        for(int j = 1; j < len-i; j++)
        {
            if(num[j-1] < num[j])
            {
                int tmp;
                tmp = num[j-1];
                num[j-1] = num[j];
                num[j] = tmp;
            }
        }
    }
    cout<<num;
}
