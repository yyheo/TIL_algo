#include <bits/stdc++.h>
using namespace std;

int solution(int stock, vector<int> dates, vector<int> supplies, int k) {
	priority_queue<int> pque;
	int answer = 0, index = 0;
	while (stock < k) {
		for (int i = index; i < dates.size(); i++) {
			if (dates[i] <= stock) {
				pque.push(supplies[i]);
			}
			else {
				index = i;
				break;
			}
		}
		stock += pque.top();
		pque.pop();
		answer++;
	}
	return answer;
}

// 출력 테스트를 위한 코드
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int answer = solution(7, { 1,2,3,4 }, { 10,20,30,40 }, 30);
	cout << answer;
}
