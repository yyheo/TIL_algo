#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int person[9], sum = 0;
	for (int i = 0; i < 9; i++) {
		cin >> person[i];
		sum += person[i];
	}
	bool find = false;
	for (int i = 0; i < 9; i++) {
		for (int j = i + 1; j < 9; j++) {
			if (sum - (person[i] + person[j]) == 100) {
				person[i] = 0;
				person[j] = 0;
				find = true;
				break;
			}
		}
		if (find == true) break;
	}
	sort(person, person + 9);
	for (int i = 0; i < 9; i++) {
		if (person[i] != 0) cout << person[i] << "\n";
	}
}