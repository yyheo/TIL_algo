#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, x, y, dir, gen;
int dx[] = { 0, -1, 0, 1 };
int dy[] = { 1, 0, -1, 0 };
bool check[101][101];

vector<int> curve(int x, int y, int dir, int gen) { // 커브 방향 기록
	vector<int> ans = { dir };
	for (int g = 1; g <= gen; g++) {
		vector<int> temp = { ans };
		reverse(temp.begin(), temp.end()); // 방향 반대로
		for (int &i : temp) i = (i + 1) % 4; // 180도 회전
		ans.insert(ans.end(), temp.begin(), temp.end());
	}
	return ans;
}

int main(void) {

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> y >> x >> dir >> gen;
		vector<int> dirs = curve(x, y, dir, gen);
		check[x][y] = true;
		for (int d : dirs) {
			x += dx[d];
			y += dy[d];
			check[x][y] = true;
		}
	}

	int ans = 0;

	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			if (check[i][j] && check[i][j + 1] && check[i + 1][j] && check[i + 1][j + 1]) ans += 1;
		}
	}

	cout << ans;

	return 0;
}
