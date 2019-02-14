#include <iostream>
#include <queue>
using namespace std;

int main(void) {
	int T, N, M, imp;
	scanf("%d", &T);
	while (T--) {
		scanf("%d %d", &N, &M);
		queue<pair<int, int>> print;
		priority_queue<int> que;
		for (int i = 0; i < N; i++) { // 프린터 큐, 우선순위 큐에 입력받기
			int temp;
			cin >> temp;
			print.push(make_pair(i, temp));
			que.push(temp);
		}
		for (int i = 1; i <= N; i++) {
			if (print.front().second == que.top()) {
				if (print.front().first == M) cout << i << "\n";
				que.pop();
				print.pop();
			}
			else {
				print.push(print.front());
				print.pop();
				i--;
			}
		}
	}
}
