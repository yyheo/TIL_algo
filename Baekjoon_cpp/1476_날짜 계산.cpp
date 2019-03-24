#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int E, S, M;
	cin >> E >> S >> M;
	int answer = 1;
	int numE = 1, numS = 1, numM = 1;
	while (true) {
		if (numE == E && numS == S && numM == M) break;
		numE += 1;
		numS += 1;
		numM += 1;
		if (numE > 15) numE -= 15;
		if (numS > 28) numS -= 28;
		if (numM > 19) numM -= 19;
		answer += 1;
	}
	cout << answer;
}