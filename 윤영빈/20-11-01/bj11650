#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.first < b.first) {
		return true;
	}
	else if (a.first == b.first) {
		return a.second < b.second;
	}
	else
		return false;
}

int main() {
	int num;
	cin >> num;

	vector<pair<int, int>> p(num);

	for (int i = 0; i < num; i++) {
		cin >> p[i].first >> p[i].second;
	}

	sort(p.begin(), p.end(), cmp);

	for (int i = 0; i < num; i++) {
		cout << p[i].first << " " << p[i].second << "\n";
	}
}
