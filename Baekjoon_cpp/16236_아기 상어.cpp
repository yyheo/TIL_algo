#include <bits/stdc++.h>
using namespace std;

struct SHARK {
	int y, x, time;
};

int dy[4] = { -1, 1, 0, 0 };
int dx[4] = { 0, 0, -1, 1 };
int sea[20][20];
SHARK shark;
int N, shark_eat, shark_size;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	for (int y = 0; y < N; ++y) {
		for (int x = 0; x < N; ++x) {
			cin >> sea[y][x];
			if (sea[y][x] == 9) {
				shark.y = y, shark.x = x, shark.time = 0;
				shark_size = 2, shark_eat = 0;
				sea[y][x] = 0;
			}
		}
	}
	bool is_update = true;
	while (is_update) {
		is_update = false;
		queue<SHARK> q;
		int visit[20][20] = { false, };
		visit[shark.y][shark.x] = true;
		q.push(shark);
		
		SHARK candi;
		candi.y = 20, candi.time = -1;
		while (!q.empty()) {
			SHARK cur = q.front(); q.pop();
			if (candi.time != -1 && candi.time < cur.time) { // 갱신이 됐고, 가장 가까운 물고기를 잡았을 경우 (+1초가 되는 지점에서 체크)
				break;
			}
			if (sea[cur.y][cur.x] < shark_size && sea[cur.y][cur.x] != 0) { // 물고기를 먹을 수 있음
				is_update = true;
				if (candi.y > cur.y || (candi.y == cur.y && candi.x > cur.x)) { // 거리가 같은 물고기일 경우 y, x 체크
					candi = cur;
				}
			}
			for (int i = 0; i < 4; i++) {
				SHARK next;
				next.y = cur.y + dy[i];
				next.x = cur.x + dx[i];
				next.time = cur.time + 1;
				if (next.y < 0 || next.y >= N || next.x < 0 || next.x >= N) continue;
				if (visit[next.y][next.x] || sea[next.y][next.x] > shark_size) continue;
				visit[next.y][next.x] = true;
				q.push(next);
			}
		}
		if (is_update == true) { // 아기 상어가 물고기를 먹었을 경우
			shark = candi;
			shark_eat += 1;
			if (shark_eat == shark_size) {
				shark_size += 1;
				shark_eat = 0;
			}
			sea[shark.y][shark.x] = 0;
		}
	}
	cout << shark.time;
}