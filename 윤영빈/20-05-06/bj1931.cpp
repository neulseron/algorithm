#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct t
{
	int start;
	int end;
};

bool cmp(t a, t b)
{
	if (a.end == b.end)
		return (a.start) < (b.start);
	else
		return (a.end) < (b.end);
}

int main()
{
	int n;
	cin >> n;

	//input
	vector<t> arr(n);
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i].start >> arr[i].end;
	}

	sort(arr.begin(), arr.end(), cmp);

	int count = 0, cp = 0;

	for (int i = 0; i < n; i++)
	{
		if (cp <= arr[i].start)
		{
			++count;
			cp = arr[i].end;
		}
	}
	
	cout << count;
}
