#include <bits/stdc++.h>
using namespace std;
int main(void) {
	int T, answer = 0;
	string word;
	cin >> T;
	while (T--) {
		stack<int> check;
		cin >> word;
		for (int i = 0; i < word.size(); i++) {
			if (check.empty() == 0 && check.top() == word[i]) check.pop();
			else check.push(word[i]);
		}
		if (check.empty() == 1) answer += 1;
	}
	cout << answer;
}