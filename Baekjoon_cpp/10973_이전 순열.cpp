#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int N;
	cin >> N;
	vector<int> num(N);
	for (int i = 0; i < N; i++) cin >> num[i];
	if (next_permutation(num.begin(), num.end())) {
		for (int i = 0; i < N; i++) cout << num[i] << " ";
	}
	else cout << "-1";
	
}