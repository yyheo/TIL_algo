#include <iostream>
#include <string>
#include <deque>
using namespace std;

int main(void) {
	int N;
	scanf("%d", &N);
	string str;
	deque<int> answer;
	while (N--) {
		cin >> str;
		if (str == "push_front") {
			int num;
			scanf("%d", &num);
			answer.push_front(num);
		}
		else if (str == "push_back") {
			int num;
			scanf("%d", &num);
			answer.push_back(num);
		}
		else if (str == "pop_front") {
			if (answer.size() == 0) cout << "-1" << "\n";
			else {
				cout << answer.front() << "\n";
				answer.pop_front();
			}
		}
		else if (str == "pop_back") {
			if (answer.size() == 0) cout << "-1" << "\n";
			else {
				cout << answer.back() << "\n";
				answer.pop_back();
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
