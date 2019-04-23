#include <iostream>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int a, b, tmp;
	cin >> a >> b;
	tmp = (a > b ? b : a);
	while ((a % tmp) != 0 || (b % tmp) != 0) {
		tmp -= 1;
	}
	cout << tmp << "\n" << tmp * (a / tmp) * (b / tmp);
	return 0;
}