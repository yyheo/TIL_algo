#include <bits/stdc++.h>
using namespace std;
int minS, N;
int synergy[17][17];
int check[17];

void selectFood(int cnt, int index) {
	if (cnt < 0 || index >= N) return;
	if (cnt == 0) { // 2개 다 선택했을 경우
		int foodA = 0; // true인 음식끼리
		int foodB = 0; // false인 음식끼리
		for (int i = 0; i < N; i++) {
			if (check[i] == true) {
				for (int j = 0; j < N; j++) {
					if (check[j] == true) foodA += synergy[i][j];
				}
			}
			else {
				for (int j = 0; j < N; j++) {
					if (check[j] == false) foodB += synergy[i][j];
				}
			}
		}
		minS = abs(foodA - foodB) < minS ? abs(foodA - foodB) : minS; // 최소 값 갱신
		return;
	}
	check[index] = false; // 선택 안 했을 경우
	selectFood(cnt, index + 1);
	check[index] = true; // 선택 했을 경우
	selectFood(cnt - 1, index + 1);
	check[index] = false;
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int T, i = 1;
	cin >> T;
	while (T--) {
		cin >> N;
		minS = 20000;
		for (int i = 0; i < N; i++) {
			// 시너지 배열 입력
			for (int j = 0; j < N; j++) cin >> synergy[i][j];
		}
		int cnt = N / 2;
		selectFood(cnt, 0);
		cout << "#" << i++ << " " << minS << "\n";
	}
}