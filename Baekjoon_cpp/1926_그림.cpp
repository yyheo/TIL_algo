#include <bits/stdc++.h>
using namespace std;
int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;
	vector< vector<int> > rand(n, vector<int>(m));
	vector< vector<bool> > visit(n, vector<bool>(m, false));
	for (int i = 0; i < n; i++) { // 입력 받기
		for (int j = 0; j < m; j++) {
			cin >> rand[i][j];
		}
	}
	int numPic = 0, maxPic = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (rand[i][j] == 0 || visit[i][j] == true) continue;
			queue<pair<int, int>> que;
			visit[i][j] = true;
			que.push({ i, j });
			numPic++;
			int sizePic = 1;
			while (!que.empty()) {
				auto cur = que.front();
				que.pop();
				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.first + dx[dir];
					int ny = cur.second + dy[dir];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if (visit[nx][ny] || rand[nx][ny] != 1) continue;
					visit[nx][ny] = 1;
					que.push({ nx, ny });
					sizePic++;
				}
			}
			if (sizePic > maxPic) maxPic = sizePic;
		}
	}
	cout << numPic << "\n" << maxPic;
}