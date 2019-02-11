#include <iostream>
#include <string>
#include <stack>
using namespace std;

int VPS(string str)
{
	stack<int> answer;
	int sum = 0;
	for (int i = 0; i < str.size(); i++) {
		if (str[i] == ')') {
			if (answer.top() == '(') {
				answer.pop();
				answer.push(2);
			}
			else if (answer.top() >= 0 && answer.top() <= 9) {
				int temp = answer.top();
				answer.pop();
				if (answer.top() == '(') {
					answer.pop();
					answer.push(temp * 2);
				}
			}
		}
		else if (str[i] == ']') {
			if (answer.top() == '[') {
				answer.pop();
				answer.push(3);
			}
			else if (answer.top() >= 0 && answer.top() <= 9) {
				int temp = answer.top();
				answer.pop();
				if (answer.top() == '[') {
					answer.pop();
					answer.push(temp * 3);
				}
			}
		}
		else { answer.push(str[i]); }
	}

	for (int i = 0; i < answer.size(); i++) {
		sum += answer.top();
		answer.pop();
	}

	return 0;
}

int main(void)
{
	string str;
	cin >> str;
	cout << VPS(str);
}