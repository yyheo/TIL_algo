#include <iostream>
#include <string>
using namespace std;
int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	string str;
	cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		cin >> str;
		bool check = true;
		for (int i = 0; i < str.size() / 2; i++) {
			if (str[i] != str[str.size() - i - 1]) {
				check = false;
				break;
			}
		}
		cout << "#" << tc << " " << check << "\n";
	}
}