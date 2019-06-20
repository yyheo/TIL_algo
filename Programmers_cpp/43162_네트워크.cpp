#include <string>
#include <vector>
#include <iostream>
using namespace std;
int visit[201];
int dfs(int start, int n, vector<vector<int>> computers) {
	visit[start] = 1;
	for (int i = 0; i < n; i++) {
		if (visit[i] || !computers[start][i]) continue;
		dfs(i, n, computers);
	}
	return 0;
}
int solution(int n, vector<vector<int>> computers) {
	int answer = 0;
	for (int i = 0; i < n; i++) {
		if (!visit[i]) {
			answer += 1;
			dfs(i, n, computers);
		}
	}
	return answer;
}
int main() {
	cout << solution(3, { {1,1,0}, {1,1,0}, {0,0,1} });
	return 0;
}