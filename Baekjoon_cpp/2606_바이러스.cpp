#include <iostream>
#include <cstdio>
using namespace std;

int n, m;
int com[101][101];
int vis[101];
int vir = -1;

void In(){
	scanf("%d%d", &n, &m);
	for (int i = 0; i < m; i++) {
		int x, y;
		scanf("%d %d", &x, &y);
		com[x][y] = com[y][x] = 1;
	}
}

void DFS(int cur) {
	vis[cur] = 1;
	vir++;
	for (int i = 1; i <= n; i++) {
		if (com[cur][i] && !vis[i]) {
			DFS(i);
		}
	}
}

int main(void) {
	In();
	DFS(1);
	cout << vir;
}
