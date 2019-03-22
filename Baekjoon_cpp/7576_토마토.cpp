#include <bits/stdc++.h>
using namespace std;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int M, N;
	cin >> N >> M;
	vector<vector<int>> tomato(M, vector<int>(N));
	queue<pair<int, int>> Q;
	for (int i = 0; i < M; i++) { // 토마토 입력 받음
		for (int j = 0; j < N; j++) {
			cin >> tomato[i][j];
			if (tomato[i][j] == 1) {
				Q.push({ i, j }); // 익은 토마토일 경우 Q에 push
			}
		}
	}

	// BFS
	while (!Q.empty()) {
		auto cur = Q.front();
		Q.pop();
		int x = cur.first;
		int y = cur.second;
		for (int dir = 0; dir < 4; dir++) { // 상하좌우 탐색
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N || tomato[nx][ny] == -1) continue;
			if (tomato[nx][ny] == 0) {
				tomato[nx][ny] = tomato[x][y] + 1;
				Q.push({ nx, ny });
			}
		}
	}

	int max = 0;
	for (int i = 0; i < M; i++) { // 토마토 입력 받음
		for (int j = 0; j < N; j++) {
			if (tomato[i][j] == 0) {
				cout << -1;
				return 0;
			}
			else if (tomato[i][j] > max) max = tomato[i][j];
		}
	}
	cout << max - 1;
}