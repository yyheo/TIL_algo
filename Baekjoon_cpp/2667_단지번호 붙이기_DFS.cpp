#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;

int n, cnt = 0;
int arr[26][26], num[1001];
int vis[26][26];
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { 1, -1, 0, 0 };

void In(){
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%1d", &arr[i][j]);
		}
	}
}

void DFS(int x, int y) {
	vis[x][y] = 1;
	num[cnt]++;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			if (arr[nx][ny] && !vis[nx][ny]) DFS(nx, ny);
		}
	}
}

int main(void) {
	In();

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j] && !vis[i][j]) {
				DFS(i, j);
				cnt++;
			}
		}
	}

	printf("%d\n", cnt);
	sort(num, num + cnt);
	for (int i = 0; i < cnt; i++) printf("%d\n", num[i]);

}
