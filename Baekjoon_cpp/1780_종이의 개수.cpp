#include <iostream>
#include <vector>
using namespace std;
int map[2188][2188];
int ans[3];
int N;


void checkPap(int y, int x, int N) {
	int start = map[y][	x];
	bool flag = true;
	for (int i = y; i < y + N; i++) {
		for (int j = x; j < x + N; j++) {
			if (map[i][j] != start) {
				flag = false;
				break;
			}
		}
		if (!flag) break;
	}
	if (flag) {
		ans[start + 1] += 1;
	}
	else {
		for (int i = y; i < y + N; i += N / 3) {
			for (int j = x; j < x + N; j += N / 3) {
				checkPap(i, j, N/3);
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) cin >> map[i][j];
	}
	checkPap(0, 0, N);
	for (int i = 0; i < 3; i++) {
		cout << ans[i] << "\n";
	}
	return 0;
}