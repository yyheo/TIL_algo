#include <bits/stdc++.h>
using namespace std;
int city[11][11];
int visit[11];
int N, first;
int minCost = 987654321;

void dfs(int cur, int sum, int cnt) {
	visit[cur] = 1;
	if (cnt == N - 1 && city[cur][first] != 0) { // 모두 순회 완료일 경우
		sum += city[cur][first];
		if (minCost > sum) minCost = sum;
		return;
	}
	for (int i = 0; i < N; i++) {
		if (city[cur][i] == 0) continue; // 연결되지 않았을 경우
		if (visit[i] == 0) {
			dfs(i, sum + city[cur][i], cnt + 1);
			visit[i] = 0;
		}
	}
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> city[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
		first = i;
		dfs(i, 0, 0);
	}
	cout << minCost;
}