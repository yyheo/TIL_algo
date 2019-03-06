#include <bits/stdc++.h>
using namespace std;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N, M;
	cin >> N >> M;
	vector<string> map(N);
	vector<vector<int>> dist(N, vector<int>(M, 0));
	for (int i = 0; i < N; i++) {
		cin >> map[i];
	}
	queue<pair<int, int>> que;
	dist[0][0] = 1;
	que.push({ 0,0 });
	while (!que.empty()) {
		auto cur = que.front();
		que.pop();
		for (int i = 0; i < 4; i++) {
			int nx = cur.first + dx[i];
			int ny = cur.second + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if (map[nx][ny] != '1' || dist[nx][ny] != 0) continue;
			dist[nx][ny] = dist[cur.first][cur.second] + 1;
			que.push({ nx,ny });
		}
	}
	cout << dist[N - 1][M - 1];
}