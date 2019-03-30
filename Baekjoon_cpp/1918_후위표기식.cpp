#include <bits/stdc++.h>
using namespace std;
int main(void) {
	string num;
	cin >> num;
	queue<char> answer;
	stack<char> stk;
	for (int i = 0; i < num.size(); i++) {
		// 알파벳일 경우 : que에 넣어줌
		if (num[i] >= 'A' && num[i] <= 'Z') answer.push(num[i]);
		// (일 경우 : 무조건 stack에 넣음
		else if (num[i] == '(') stk.push(num[i]);
		// )일 경우 : (위에 있는 모든 연산자 pop해서 quq에 넣어줌
		else if (num[i] == ')') {
			while (stk.top() != '(') {
				answer.push(stk.top());
				stk.pop();
			}
			stk.pop();
		}
		// 연산자일 경우 : stack의 top이 더 우선순위가 낮다면 그냥 push, 아니면 top을 que에 옮겨줌
		else if (num[i] == '+' || num[i] == '-') {
			while (stk.empty() == 0) {
				if (stk.top() == '(') break;
				answer.push(stk.top());
				stk.pop();
			}
			stk.push(num[i]);
		}
		else if (num[i] == '*' || num[i] == '/') {
			while (stk.empty() == 0) {
				if (!(stk.top() == '*' || stk.top() == '/')) break;
				answer.push(stk.top());
				stk.pop();
			}
			stk.push(num[i]);
		}
	}
	while (!stk.empty()) { // 스택에 남은 연산자 처리
		answer.push(stk.top());
		stk.pop();
	}
	while (!answer.empty()) {
		cout << answer.front();
		answer.pop();
	}
}