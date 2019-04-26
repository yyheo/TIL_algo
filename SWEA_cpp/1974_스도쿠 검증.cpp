#include <iostream>
#include <vector>
#include <string.h>
using namespace std;
int sdoku[9][9];

int yCheck() {
	// 가로 check
	for (int i = 0; i < 9; i++) {
		int sum = 0;
		for (int j = 0; j < 9; j++) {
			sum += sdoku[i][j];
		}
		if (sum != 45) {
			return 0;
		}
	}
}
int xCheck() {
	// 세로 check
	for (int i = 0; i < 9; i++) {
		int sum = 0;
		for (int j = 0; j < 9; j++) {
			sum += sdoku[j][i];
		}
		if (sum != 45) {
			return 0;
		}
	}
}
int boxCheck() {
	// 네모 check
	for (int i = 0; i < 9; i = i + 3) {
		for (int j = 0; j < 9; j = j + 3) {
			int sum = 0;
			for (int y = i; y < i + 3; y++) {
				for (int x = j; x < j + 3; x++) {
					sum += sdoku[y][x];
				}
			}
			if (sum != 45) {
				return 0;
			}
		}
	}
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int T;
	cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		// 스도쿠 입력
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cin >> sdoku[i][j];
			}
		}
		if (xCheck() && yCheck() && boxCheck()) cout << "#" << tc << " " << 1 << "\n";
		else cout << "#" << tc << " " << 0 << "\n";
	}
}
