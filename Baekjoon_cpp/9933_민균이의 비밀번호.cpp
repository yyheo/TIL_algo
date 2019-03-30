#include <bits/stdc++.h>
using namespace std;
int main(void) {
	int T;
	cin >> T;
	vector<string> word(T);
	for (int i = 0; i < T; i++) cin >> word[i];
	for (int i = 0; i < T; i++) {
		for (int j = 0; j < T; j++) {
			int woSize = word[i].size();
			if (woSize != word[j].size()) continue;
			if (word[i][0] != word[j][woSize - 1] || word[i][0] != word[j][woSize - 1]) continue;
			for (int k = 0; k < woSize; k++) {
				if (word[i][k] != word[j][woSize - k - 1]) break;
				else if (k == woSize - 1) {
					cout << woSize << " " << word[i][woSize / 2];
					return 0;
				}
			}
		}
	}
}