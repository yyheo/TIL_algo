#include <bits/stdc++.h>
using namespace std;

int dx[6] = { -1, 1, 0, 0, 0, 0 };
int dy[6] = { 0, 0, -1, 1, 0, 0 };
int dz[6] = { 0, 0, 0, 0, -1, 1 };
int tomato[100][100][100];
int visit[100][100][100];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int M, N, H;
	cin >> N >> M >> H;
	queue<tuple<int, int, int>> Q;
	for (int k = 0; k < H; k++) {
		for (int i = 0; i < M; i++) { // 토마토 입력 받음
			for (int j = 0; j < N; j++) {
				cin >> tomato[k][i][j];
				if (tomato[k][i][j] == 1) {
					Q.push({ k, i, j }); // 익은 토마토일 경우 Q에 push
				}
			}
		}
	}

	// BFS
	while (!Q.empty()) {
		auto cur = Q.front();
		Q.pop();
		int z = get<0>(cur);
		int x = get<1>(cur);
		int y = get<2>(cur);
		for (int dir = 0; dir < 6; dir++) { // 상하좌우 탐색
			int nz = z + dz[dir];
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H || tomato[nz][nx][ny] == -1) continue;
			if (tomato[nz][nx][ny] == 0) {
				tomato[nz][nx][ny] = tomato[z][x][y] + 1;
				Q.push({ nz, nx, ny});
			}
		}
	}

	int max = 0;
	for (int k = 0; k < H; k++) {
		for (int i = 0; i < M; i++) { // 토마토 입력 받음
			for (int j = 0; j < N; j++) {
					if (tomato[k][i][j] == 0) {
						cout << -1;
						return 0;
					}
					else if (tomato[k][i][j] > max) max = tomato[k][i][j];
			}
		}
	}
	cout << max - 1;
}