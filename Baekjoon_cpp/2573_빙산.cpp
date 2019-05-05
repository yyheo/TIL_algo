#include <iostream>
#include <string.h>
using namespace std;
int N, M;
int map[301][301];
int visit[301][301];
int dy[4] = { 0,0,-1,1 };
int dx[4] = { -1,1,0,0 };

void melt(int y, int x) {
	int water = 0;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
		if (map[ny][nx] == 0) water += 1;
	}
	int nextIce = map[y][x] - water;

	if (nextIce == 0) map[y][x] = -1;
	else map[y][x] -= water;
}

void dfs(int y, int x) {
	visit[y][x] = 1;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (map[ny][nx] < 0) map[ny][nx] = 0;
		if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
		if (!map[ny][nx]|| visit[ny][nx]) continue;
		dfs(ny, nx);
	}
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> M;
	for (int y = 0; y < N; y++) {
		for (int x = 0; x < M; x++) {
			cin >> map[y][x];
		}
	}

	int answer = 0;
	while (true) {
		answer += 1; // + 1년
		memset(visit, 0, sizeof(visit));
		int iceNum = 0;
		// 빙산 녹이기
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (map[y][x] != 0) melt(y, x);
				if (map[y][x] > 0) iceNum += 1;
			}
		}
		// 다 녹을 때까지 분리되지 않으면 0 출력
		if (iceNum == 0) {
			cout << 0;
			return 0;
		}
		// 빙산 갯수 세기
		int cnt = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (map[y][x] < 0) map[y][x] = 0;
				if (map[y][x] == 0 || visit[y][x]) continue;
				cnt += 1;
				dfs(y, x);
			}
		}
		if (cnt > 1) {
			cout << answer;
			return 0;
		}
	}
}