#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	string str;
	int M, num, bitmask = 0;
	cin >> M;
	vector<int> S;
	while (M--) {
		cin >> str;
		if (str == "add") {
			cin >> num;
			bitmask |= 1 << num;
		}
		else if (str == "remove") {
			cin >> num;
			bitmask &= ~(1 << num);
		}
		else if (str == "check") {
			cin >> num;
			if (bitmask & (1 << num)) cout << 1 << "\n";
			else cout << 0 << "\n";
		}
		else if (str == "toggle") {
			cin >> num;
			bitmask ^= 1 << num;
		}
		else if (str == "all") {
			bitmask = (1 << 21) - 1;
		}
		else if (str == "empty") {
			bitmask = 0;
		}
	}
}