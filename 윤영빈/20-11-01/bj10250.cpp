#include <iostream>
#include <vector>

using namespace std;

typedef struct h_info
{
	int H;
	int W;
	int N;
	int room;
};

int main() {
	int testnum;
	cin >> testnum;

	vector<h_info> info(testnum);
	for (int i = 0; i < testnum; i++) {
		cin >> info[i].H >> info[i].W >> info[i].N;
	}

	int tmp;
	int tmp2;
	for (int i = 0; i < testnum; i++) {
		tmp = info[i].N % info[i].H;
		tmp2 = info[i].N / info[i].H;
		if (tmp == 0) {
			tmp = info[i].H;
			tmp2 -= 1;
		}
		info[i].room = tmp * 100 + tmp2 + 1;
		cout << info[i].room << "\n";
	}
}
