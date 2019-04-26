#include <iostream>
#include <string.h>
#include <string>
using namespace std;
int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N, ans = 0;
	bool check;
	int alpha[26];
	string str;
	cin >> N;
	while (N--) {
		check = true;
		memset(alpha, 0, sizeof(alpha));
		cin >> str;
		for (int i = 0; i < str.size(); i++) {
			if (i != 0 && str[i - 1] != str[i]) {
				if (alpha[str[i] - 97] != 0) {
					check = false;
					break;
				}
			}
			alpha[str[i] - 97] += 1;
		}
		if (check == true) ans += 1;
	}
	cout << ans;
}