#include <bits/stdc++.h>
using namespace std;
int main(void) {
	string str, bomb, answer = "";
	cin >> str >> bomb;
	for (int i = 0; i < str.size(); i++) {
		bool explode = false;
		if (str[i] == bomb[0]) {
			bool check = true;
			for (int j = 0; j < bomb.size(); j++) {
				if (str[i + j] != bomb[j]) {
					check = false;
					break;
				}
			}
			if (check == true) {
				str.erase(i, bomb.size());
				explode = true;
			}
		}
		if (explode == true) i -= 2;
	}
	if (str.size() == 0) cout << "FRULA";
	else cout << str;
}