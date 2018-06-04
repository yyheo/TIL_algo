#include <iostream>
#include <queue>
using namespace std;

int n, m;
int cheese[1001][1001];
int visit[1001][1001];
int time = 0;
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int check;

queue<pair<int,int>> que;

void nullcheck() { // 모든 치즈가 녹았는지 확인
	check = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (cheese[i][j] != -1) check++;
		}
	}
}

void findair(int x, int y) { // DFS

	visit[x][y] = 1;
	cheese[x][y] = -1;
	que.push({ x, y });

	for (int i = 0; i < 4; i++) {
		int ax = x + dx[i];
		int ay = y + dy[i];
		if (ax >= 0 && ay >= 0 && ax < n && ay < m && visit[ax][ay] != 1 && cheese[ax][ay] != 1)
			findair(ax, ay);
	}
}

void contactair(int x, int y) { // 공기와 맞닿은 면의 수 세기
	int cnt = 0;
	for (int i = 0; i < 4; i++) {
		int ax = x + dx[i];
		int ay = y + dy[i];
		if (cheese[x][y] == 1 && cheese[ax][ay] == -1)
			cnt++;
	}
	if (cnt>1) cheese[x][y] = cnt;
}

void delcheese(int x, int y) { // 공기와 맞닿은 면이 2개 이상인 치즈 녹이기
	if (cheese[x][y] >= 2) cheese[x][y] = -1;
}

void initvisit() { // visit 초기화
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			visit[i][j] = 0;
		}
	}
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &cheese[i][j]);
		}
	}

	do {
		findair(0, 0);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				contactair(i, j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				delcheese(i, j);
			}
		}

		//for (int i = 0; i < n; i++) {
		//	for (int j = 0; j < m; j++) {
		//		if (j % 9 == 0) printf("\n");
		//		printf("%d ", cheese[i][j]);

		//	}
		//}
		//printf("\n");

		initvisit();
		nullcheck();
		time++;
	} while (check != 0);

	printf("%d", time);
}
