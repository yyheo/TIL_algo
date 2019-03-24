#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N;
	cin >> N;
	vector<int> num(N);
	for (int i = 0; i < N; i++) num[i] = i + 1;
	do {
		for (int i = 0; i < N; i++) cout << num[i] << " ";
		cout << "\n";
	} while (next_permutation(num.begin(), num.end()));
}