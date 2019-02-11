#include <iostream>
#include <queue>
using namespace std;

int graph[1001][1001];
int visit[1001];
int n, m, v;
int a, b;

void DFS(int start) {
	printf("%d ", start);
	for (int i = 0; i <= n; i++) {
		if (graph[start][i] && visit[i] == 0) {
			visit[i] = 1;
			DFS(i);
		}
	}
}

void BFS(int start) {
	queue<int> que;
	for (int i = 0; i <= n; i++)
		visit[i] = 0; // visit 체크 초기화
	que.push(start);
	visit[start] = 1;

	while (!que.empty()) {
		int num = que.front();
		printf("%d ", num);

		for (int i = 0; i <= n; i++) {
			if (graph[num][i] && visit[i] == 0) {
				visit[i] = 1;
				que.push(i);
			}
		}
		que.pop();
	}

}

int main() {
	scanf("%d %d %d", &n, &m, &v); // 정점과 간선 개수, 탐색 시작 번호 입럭 받음

	for (int i = 0; i < m; i++) {
		scanf("%d %d", &a, &b);
		
		graph[a][b] = graph[b][a] = 1;
	}

	visit[v] = 1;
	DFS(v);
	cout << "\n";
	BFS(v);
}
