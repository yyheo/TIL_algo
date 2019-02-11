#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main(void) {
	int N;
	scanf("%d", &N);
	string str;
	queue<int> answer;
	while (N--) {
		cin >> str;
		if (str == "push") {
			int num;
			scanf("%d", &num);
			answer.push(num);
		}
		else if (str == "pop") {
			if (answer.size() == 0) cout << "-1" << "\n";
			else {
				cout << answer.front() << "\n";
				answer.pop();
			}
		}
		else if (str == "size") {
			cout << answer.size() << "\n";
		}
		else if (str == "empty") {
			cout << answer.empty() << "\n";
		}
		else if (str == "front") {
			if (answer.size() == 0) cout << "-1" << "\n";
			else {
				cout << answer.front() << "\n";
			}
		}
		else if (str == "back") {
			if (answer.size() == 0) cout << "-1" << "\n";
			else {
				cout << answer.back() << "\n";
			}
		}
	}
}
