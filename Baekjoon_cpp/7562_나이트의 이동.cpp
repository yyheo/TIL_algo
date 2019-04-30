#include <iostream>
#include <queue>
#include <string.h>
using namespace std;
struct POSI {
	int y, x, cnt;
};
int T, I;
POSI start, target;
int map[301][301];
int dy[8] = {-2, -2, -1, -1, +2, +2, +1, +1};
int dx[8] = { -1, +1, -2, +2, -1, +1, -2, +2 };

int main(void) {
	cin >> T;
	while (T--) {
		queue<POSI> Q;
		cin >> I;
		cin >> start.y >> start.x;
		cin >> target.y >> target.x;
		memset(map, 0, sizeof(map));
		start.cnt = 0;
		Q.push(start);
		map[start.y][start.x] = 1;
		// BFS
		while (!Q.empty()) {
			POSI cur = Q.front(); Q.pop();
			if (cur.y == target.y && cur.x == target.x) { // 타겟에 도달하면 종료
				cout << cur.cnt << "\n";
				break;
			}
			for (int i = 0; i < 8; i++) { // 8방향 탐색
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				int ncnt = cur.cnt + 1;
				if (ny < 0 || nx < 0 || ny >= I || nx >= I) continue;
				if (map[ny][nx] == 1) continue;
				map[ny][nx] = 1;
				Q.push({ ny, nx, ncnt });
			}
		}
	}
}