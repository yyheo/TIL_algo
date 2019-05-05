#include <iostream>
#include <string.h>
using namespace std;
int N, maxN = 1;
int map[101][101];
int visit[101][101];
int dy[4] = { 0, 0, +1, -1 };
int dx[4] = { +1, -1, 0, 0 };
int answer = 1;

void dfs(int y, int x, int w) {
	visit[y][x] = 1;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
		if (visit[ny][nx] || map[ny][nx] <= w) continue;
		dfs(ny, nx, w);
	}
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	for (int y = 0; y < N; y++) {
		for (int x = 0; x < N; x++) {
			cin >> map[y][x];
			if (map[y][x] > maxN) maxN = map[y][x];
		}
	}
	for (int w = 1; w < maxN; w++) {
		int check = 0;
		memset(visit, 0, sizeof(visit));
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] > w && !visit[y][x]) {
					check += 1;
					dfs(y, x, w);
				} else visit[y][x] = 1;
			}
		}
		if (check > answer) answer = check;
	}
	cout << answer;
}