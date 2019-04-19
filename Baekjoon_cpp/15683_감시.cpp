#include <bits/stdc++.h>
using namespace std;

struct CCTV {
	int y, x, type;
};

int N, M, cctv_size, answer;
CCTV cctv[8];
int office[8][8];
int rot[5] = { 4, 2, 4, 4, 1 };

void update(int dir, CCTV cctv) {
	dir %= 4;
	if (dir == 0) { // 오른쪽
		for (int i = cctv.x + 1; i < M; i++) {
			if (office[cctv.y][i] == 6) break;
			office[cctv.y][i] = -1;
		}
	}
	else if (dir == 1) { // 위
		for (int i = cctv.y - 1; i >= 0; i--) {
			if (office[i][cctv.x] == 6) break;
			office[i][cctv.x] = -1;
		}
	}
	else if (dir == 2) { // 왼쪽
		for (int i = cctv.x - 1; i >= 0; i--) {
			if (office[cctv.y][i] == 6) break;
			office[cctv.y][i] = -1;
		}
	}
	else if (dir == 3) { // 아래
		for (int i = cctv.y + 1; i < N; i++) {
			if (office[i][cctv.x] == 6) break;
			office[i][cctv.x] = -1;
		}
	}
}

void copyOffice(int tar[8][8], int ori[8][8]) {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			tar[i][j] = ori[i][j];
		}
	}
}

void dfs(int cctv_index) {
	if (cctv_index == cctv_size) { // 다 돌았을 경우
		int check = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (office[y][x] == 0) check += 1;
			}
		}
		if (check < answer) {
			answer = check;
		}
		return;
	}

	int officeBUP[8][8];
	for (int dir = 0; dir < rot[cctv[cctv_index].type]; dir++) {
		copyOffice(officeBUP, office);
		if (cctv[cctv_index].type == 0) {
			update(dir, cctv[cctv_index]);
		} else if (cctv[cctv_index].type == 1) {
			update(dir, cctv[cctv_index]);
			update(dir + 2, cctv[cctv_index]);
		} else if (cctv[cctv_index].type == 2) {
			update(dir, cctv[cctv_index]);
			update(dir + 1, cctv[cctv_index]);
		} else if (cctv[cctv_index].type == 3) {
			update(dir, cctv[cctv_index]);
			update(dir + 1, cctv[cctv_index]);
			update(dir + 2, cctv[cctv_index]);
		}	else if (cctv[cctv_index].type == 4) {
			update(dir, cctv[cctv_index]);
			update(dir + 1, cctv[cctv_index]);
			update(dir + 2, cctv[cctv_index]);
			update(dir + 3, cctv[cctv_index]);
		}
		dfs(cctv_index + 1);
		copyOffice(office, officeBUP);
	}
}

int main(void) {
	cin >> N >> M;
	for (int y = 0; y < N; ++y) {
		for (int x = 0; x < M; ++x) {
			cin >> office[y][x];
			if (office[y][x] != 6 && office[y][x] != 0) {
				cctv[cctv_size].y = y;
				cctv[cctv_size].x = x;
				cctv[cctv_size].type = office[y][x] - 1;
				++cctv_size;
			}
		}
	}
	answer = 100;
	dfs(0);
	cout << answer;
} 