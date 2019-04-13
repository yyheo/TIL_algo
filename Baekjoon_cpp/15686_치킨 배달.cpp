#include <bits/stdc++.h>
using namespace std;

struct POSI {
	int y, x;
};

int N, M, input, answer;
vector<POSI> shop, home, pick;

void dfs(int pos) {
	if (pick.size() == M) { // 전부 선택 완료 됐을 경우
		int tmp = 0;
		for (int i = 0; i < home.size(); ++i) { // 각각 집 당
			int minDis = 1000000;
			for (int j = 0; j < pick.size(); ++j) { // 각각 치킨집이랑 비교해서 가장 짧은 치킨집과의 거리 찾음
				minDis = min(minDis, abs(home[i].y - pick[j].y) + abs(home[i].x - pick[j].x));
			}
			tmp += minDis;
		}
		if (answer > tmp) {
			answer = tmp;
		}
		return;
	}
	for (int i = pos; i < shop.size(); ++i) { // 하나씩 늘려가면서 선택, 선택 완료 후에는 빠져나오면서 pop
		pick.push_back(shop[i]);
		dfs(i + 1);
		pick.pop_back();
	}
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	POSI target;
	cin >> N >> M;
	for (int y = 0; y < N; ++y) {
		for (int x = 0; x < N; ++x) {
			cin >> input;
			if (input == 1) {
				target.y = y, target.x = x;
				home.push_back(target);
			}
			else if (input == 2) {
				target.y = y, target.x = x;
				shop.push_back(target);
			}
		}
	}
	answer = 0x7fffffff;
	dfs(0);
	cout << answer;
	return 0;
}