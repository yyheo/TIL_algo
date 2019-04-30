#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int M, N, K, sum;
int map[101][101];
int dy[4] = { 1, -1, 0, 0 };
int dx[4] = { 0, 0, -1, 1 };

void dfs(int y, int x) {
	// visit 표시 2로 체크
	map[y][x] = 2;
	sum += 1;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
		if (map[ny][nx] != 0) continue;
		dfs(ny, nx);
	}
}

int main(void) {
	vector<int> answer;
	cin >> M >> N >> K;
	while (K--) {
		int y, x, y2, x2;
		cin >> x >> y >> x2 >> y2;
		// 색칠된 사각형은 1로 체크
		for (int i = y; i < y2; i++) {
			for (int j = x; j < x2; j++) {
				map[i][j] = 1;
			}
		}
	}
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] == 0) {
				sum = 0;
				dfs(i, j);
				answer.push_back(sum);
			}
		}
	}
	sort(answer.begin(), answer.end());
	cout << answer.size() << "\n";
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i] << " ";
	}
	cout << "\n";
}