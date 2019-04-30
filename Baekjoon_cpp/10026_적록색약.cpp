#include <iostream>
#include <string>
#include <string.h>
#include <vector>
using namespace std;
int N;
int dy[4] = { -1, 1, 0, 0 };
int dx[4] = {0, 0, -1, 1};
int visit[101][101];
char paint[101][101];

void dfs(int y, int x) {
	visit[y][x] = 1;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
		if (visit[ny][nx] || paint[y][x] != paint[ny][nx]) continue;
		dfs(ny, nx);
	}
}

int main(void) {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> paint[i][j];
		}
	}
	int answer = 0, answer2 = 0;
	// 적록색약이 아닌 구역 수
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visit[i][j]) continue;
			dfs(i, j);
			answer += 1;
		}
	}
	// R을 G로 바꿔줌
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (paint[i][j] == 'R') paint[i][j] = 'G';
		}
	}
	// 적록색약인 구역 수
	memset(visit, 0, sizeof(visit));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visit[i][j]) continue;
			dfs(i, j);
			answer2 += 1;
		}
	}
	cout << answer << " " << answer2;
}