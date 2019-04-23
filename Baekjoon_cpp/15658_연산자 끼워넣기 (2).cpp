#include <iostream>
using namespace std;
int minNum = 1000000001;
int maxNum = -1000000001;
int N;
int A[101];
int oper[4];
int dfs(int pos, int num, int add, int sub, int mul, int div) {
	if (pos == N - 1) {
		if (num < minNum) minNum = num;
		if (num > maxNum) maxNum = num;
		return 0;
	}
	else {
		if (add) dfs(pos + 1, num + A[pos + 1], add - 1, sub, mul, div);
		if (sub) dfs(pos + 1, num - A[pos + 1], add, sub - 1, mul, div);
		if (mul) dfs(pos + 1, num * A[pos + 1], add, sub, mul - 1, div);
		if (div) dfs(pos + 1, num / A[pos + 1], add, sub, mul, div - 1);
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}
	for (int i = 0; i < 4; i++) {
		cin >> oper[i];
	}
	dfs(0, A[0], oper[0], oper[1], oper[2], oper[3]);
	cout << maxNum << "\n" << minNum;
	return 0;
}