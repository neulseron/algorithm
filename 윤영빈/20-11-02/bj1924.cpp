#include <iostream>

using namespace std;

int main() {
	int month, date;
	cin >> month >> date;

	int total = 0;
	switch (month - 1) {
	case 11:
		total += 30;
	case 10:
		total += 31;
	case 9:
		total += 30;
	case 8:
		total += 31;
	case 7:
		total += 31;
	case 6:
		total += 30;
	case 5:
		total += 31;
	case 4:
		total += 30;
	case 3:
		total += 31;
	case 2:
		total += 28;
	case 1:
		total += 31;
	default:
		total += date;
	}

	int day = total % 7;
	string d[7] = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

	cout << d[day];
}
