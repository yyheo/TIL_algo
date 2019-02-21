#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> priorities, int location) {
	queue<pair<int, int>> print;
	priority_queue<int> que;
	for (int i = 0; i < priorities.size(); i++) { // 프린터 큐, 우선순위 큐에 입력받기
		print.push(make_pair(i, priorities[i]));
		que.push(priorities[i]);
	}
	for (int i = 1; i <= priorities.size(); i++) {
		if (print.front().second == que.top()) { // 해당 문서가 우선순위 최상위일 경우 출력
			if (print.front().first == location) return i; // 내가 인쇄 요청한 문서일 경우 리턴
			que.pop();
			print.pop();
		}
		else { // 해당 문서가 우선순위 최상위가 아닐 경우 큐의 맨 뒤로 보냄
			print.push(print.front());
			print.pop();
			i--;
		}
	}
}

// 출력 테스트를 위한 코드
int main(void) {
	int answer = solution({ 2,1,3,2 }, 2);
	cout << answer;
}
