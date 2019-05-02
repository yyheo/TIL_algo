#include <iostream>
#include <queue>
#include <string>
using namespace std;
struct POSI {
	int y, x, cnt, b;
	// cnt : 지나온 칸 갯수
	// b : 벽을 부쉈는지 여부 체크 (1이면 부숨)
};
int dy[4] = { -1, 1, 0, 0 };
int dx[4] = { 0, 0, -1, 1 };
int map[1001][1001];
int visit[1001][1001][2];
int N, M;
int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		string tmp;
		cin >> tmp;
		for (int j = 0; j < M; j++) map[i][j] = tmp[j] - '0';
	}
	queue<POSI> Q;
	Q.push({ 0, 0, 0, 0 });
	visit[0][0][0] = 1;
	while (!Q.empty()) {
		POSI cur = Q.front(); Q.pop();
		if (cur.y == N-1 && cur.x == M-1) { // 목표 도달시
			cout << cur.cnt + 1;
			return 0;
		}
		for (int i = 0; i < 4; i++) {
			int ny = cur.y + dy[i];
			int nx = cur.x + dx[i];
			int ncnt = cur.cnt + 1;
			int nb = cur.b;
			if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
			if (visit[ny][nx][nb]) continue;
			if (map[ny][nx] && nb) continue; // 벽이고 이미 부쉈을 경우
			if (map[ny][nx] && !nb) { // 벽인데 안 부쉈을 경우
				nb = 1;
			}
			Q.push({ ny,nx,ncnt,nb });
			visit[ny][nx][nb] = 1;
		}
	}
	cout << -1;
}