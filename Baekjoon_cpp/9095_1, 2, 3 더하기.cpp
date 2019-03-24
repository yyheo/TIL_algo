#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N;
	cin >> N;
	vector<int> num(N);
	for (int i=0; i<N; i++) cin >> num[i];
	sort(num.begin(), num.end());
	int max = 0;
	do {
		int sum = 0;
		for (int i = 0; i < N - 1; i++) sum += abs(num[i] - num[i + 1]);
		if (max < sum) max = sum;
	} while (next_permutation(num.begin(), num.end()));
	cout << max;
}