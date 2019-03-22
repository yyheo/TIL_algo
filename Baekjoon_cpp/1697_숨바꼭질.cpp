//#include <bits/stdc++.h>
//using namespace std;
//
//int main() {
//	ios::sync_with_stdio(0);
//	cin.tie(0);
//	int N, K;
//	cin >> N >> K;
//	vector<int> board(100001, 0);
//	board[N] = 1;
//	if (N == K) {
//		cout << 0;
//		return 0;
//	}
//	queue<int> Q;
//	Q.push(N);
//	while (!Q.empty()) {
//		int cur = Q.front();
//		int dx[3] = { cur - 1, cur + 1, cur * 2 };
//		Q.pop();
//		for (int i = 0; i < 3; i++) {
//			if (dx[i] < 0 || dx[i] > 100000) continue;
//			if (board[dx[i]] > 0) continue;
//			if (dx[i] == K) {
//				cout << board[cur];
//				return 0;
//			}
//			board[dx[i]] = board[cur] + 1;
//			Q.push(dx[i]);
//		}
//	}
//}