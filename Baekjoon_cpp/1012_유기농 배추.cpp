#include <bits/stdc++.h>
using namespace std;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int T, N, M, K;
	cin >> T;
	while (T--) {
		cin >> N >> M >> K;
		vector<vector<int>> board(N, vector<int>(M, 0));
		vector<vector<int>> visit(N, vector<int>(M, 0));
		while (K--) { // 배추가 심어져 있는 위치 입력 받음
			int x, y;
			cin >> x >> y;
			board[x][y] = 1;
		}
		queue<pair<int, int>> Q;
		int bug = 0;
		// BFS
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0 || visit[i][j]) continue;
				visit[i][j] = 1;
				Q.push({ i, j });
				bug += 1; // 각 시작마다 bug + 1
				while (!Q.empty()) {
					auto cur = Q.front();
					Q.pop();
					for (int dir = 0; dir < 4; dir++) { // 상하좌우 탐색
						int nx = cur.first + dx[dir];
						int ny = cur.second + dy[dir];
						if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
						if (visit[nx][ny] || board[nx][ny] == 0) continue;
						visit[nx][ny] = 1;
						Q.push({ nx, ny });
					}
				}
			}
		}
		cout << bug << "\n";
	}
}