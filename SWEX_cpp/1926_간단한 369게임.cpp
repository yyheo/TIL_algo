#include <iostream>
#include <string>
using namespace std;

int main(void) {
	int N;
	cin >> N;
	string ans;

	for (int i = 1; i <= N; i++) {
		string stN = to_string(i);
		ans = "";
		for (int j = 0; j < stN.length(); j++) {
			if ((stN[j] == '3' || stN[j] == '6' || stN[j] == '9')) {
				if (ans != "-" && ans != "--" && ans != "---") ans = "-";
				else ans += "-";
			}
			else {
				if (ans != "-" && ans != "--" && ans != "---") ans += stN[j];
			}
			if (j == stN.length() - 1) cout << ans << " ";
		}
	}
}
