#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N, YS = 0, MS = 0;
	cin >> N;
	while (N--) {
		int temp;
		cin >> temp;
		YS += (temp / 30 + 1) * 10;
		MS += (temp / 60 + 1) * 15;
	}

	if (MS < YS) cout << "M " << MS;
	else if (YS < MS) cout << "Y " << YS;
	else cout << "Y M " << YS;
}