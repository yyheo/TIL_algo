#include <bits/stdc++.h>
using namespace std;
int magnet[4][8];
int check[4];
int answer = 0;

void turn(int i) {
	if (check[i] == 1) { // 시계방향
		int tmp = magnet[i][7];
		for (int j = 7; j > 0; j--)
			magnet[i][j] = magnet[i][j - 1];
		magnet[i][0] = tmp;
	}
	else if (check[i] == -1) { // 반시계방향
		int tmp = magnet[i][0];
		for (int j = 1; j < 8; j++) magnet[i][j - 1] = magnet[i][j];
		magnet[i][7] = tmp;
	}
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int T, K, target, dir, i = 1;
	cin >> T;
	while (T--) {
		answer = 0;
		cin >> K;
		// 자석 정보 입력
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) cin >> magnet[i][j];
		}
		while (K--) {
			memset(check, 0, sizeof(check));
			cin >> target >> dir;
			target -= 1;
			check[target] = dir;
			for (int i = 0; i < 4; i++) {
				if (target - i - 1 >= 0 && check[target - i] != 0 && magnet[target - i][6] != magnet[target - i - 1][2]) { // target의 왼쪽으로 체크
					check[target - i - 1] = check[target - i] * -1;
				}
				if (target + i + 1 < 4 && check[target + i] != 0 && magnet[target + i][2] != magnet[target + i + 1][6]) { // target의 오른쪽으로 체크
					check[target + i + 1] = check[target + i] * -1;
				}
			}
			for (int i = 0; i < 4; i++) {
				if (check[i] != 0) turn(i);
			}
		}
		for (int i = 0; i < 4; i++) {
			if (magnet[i][0] == 1) answer += pow(2, i);
		}
		cout << "#" << i++ << " " << answer << "\n";
	}
}