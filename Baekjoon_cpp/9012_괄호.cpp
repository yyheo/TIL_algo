#include <iostream>
#include <string>
using namespace std;

int VPS(string s)
{
	int check = 0;
	for (int i = 0; i < s.size(); i++) {
		if (s[i] == '(' && check >= 0) check++;
		else if (s[i] == ')') check--;
	}
	if (check == 0) cout << "YES\n";
	else cout << "NO\n";
	return 0;
}

int main(void)
{
	int T;
	cin >> T;
	while (T--) {
		string str;
		cin >> str;
		VPS(str);
	}
}