#include <bits/stdc++.h>
using namespace std;
int t;

void combination(vector<int> S, vector<int> ansArr, int r, int index, int target) {
	if (r == 0) { // 6개 전부 선택했을 경우 출력
		for (int i = 0; i < 6; i++) cout << S[ansArr[i]] << " ";
		cout << "\n";
		return;
	}
	else if (t - target < r) return; // 나머지를 다 선택해도 6개가 안될 경우 종료
	ansArr[index] = target;
	combination(S, ansArr, r - 1, index + 1, target + 1); // 선택 되었을 경우
	combination(S, ansArr, r, index, target + 1); // 선택 안되었을 경우
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	while (true) {
		int r = 6;
		cin >> t;
		if (t == 0) break;
		vector<int> S(t);
		vector<int> ansArr(t);
		for (int i = 0; i < t; i++) cin >> S[i];
		combination(S, ansArr, r, 0, 0);
		cout << "\n";
	}
}