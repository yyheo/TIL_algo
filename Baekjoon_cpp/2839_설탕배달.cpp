#include <iostream>
using namespace std;

int main() {
	int num, sum;
	sum = 0;
	cin >> num;
	while (num!=0) {
		if (num % 5 == 0) {
			num -= 5;
			sum += 1;
			continue;
		} else if (num <= 0) {
			cout << -1;
			break;
		}
		num -= 3;
		sum += 1;
	}

	if (num >= 0) cout << sum;
}
