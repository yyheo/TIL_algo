#include <iostream>
#include <string>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	string str;
	cin >> str;
	for (int i = 0; i < str.size(); i++) {
		if (str[i] >= 'A' && str[i] <= 'Z') cout << str[i];
	}
	return 0;
}