#include <iostream>
#include <string>
#include <deque>
using namespace std;

int main(void) {
	deque<int> dq;
	int N, M, answer = 0;
	deque<int>::iterator it;

	scanf("%d %d", &N, &M);
	for (int i = 1; i <= N; i++) dq.push_back(i);
	for (int i = 0; i < M; i++) {
		int tmp, index = 1;
		scanf("%d", &tmp);

		if (tmp == dq.front()) dq.pop_front();
		else {
			for (it = dq.begin(); it < dq.end(); it++) { // 구하려는 수의 인덱스 구하기
				if (*it == tmp) break;
				index++;
			}
			int front = index - 1; // 왼쪽으로 가야하는 횟수
			int back = dq.size() - index + 1; // 오른쪽으로 가야하는 횟수
			if (front < back) { // 구하려는 수가 front와 더 가까이 있을 경우
				for (int j = 0; j < front; j++) {
					dq.push_back(dq.front());
					dq.pop_front();
					answer++;
				}
				dq.pop_front();
			}
			else { // 구하려는 수가 back과 더 가까이 있을 경우
				for (int j = 0; j < back; j++) {
					dq.push_front(dq.back());
					dq.pop_back();
					answer++;
				}
				dq.pop_front();
			}
		}
	}
	cout << answer;
}
