#include <iostream>

using namespace std;

int main()
{
	int a, v, b;
	cin>>a>>b>>v;

	int real = v - b;
	int day = 0;
	int climb = a - b;
	
	day = real / climb;
	int x = real % climb;

	if(x != 0)
		day++;

	cout<<day;
}
