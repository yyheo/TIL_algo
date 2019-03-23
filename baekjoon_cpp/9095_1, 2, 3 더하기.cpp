#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int T, n;
	cin >> T;
	while (T--) {
		cin >> n;
		vector<int> answer;
		if (n >= 4) answer.resize(n+1);
		else answer.resize(4);
		answer[0] = 0;
		answer[1] = 1;
		answer[2] = 2;
		answer[3] = 4;
		for (int i = 4; i <= n; i++) {
			answer[i] = answer[i - 1] + answer[i - 2] + answer[i - 3];
		}
		cout << answer[n] << "\n";
	}
}