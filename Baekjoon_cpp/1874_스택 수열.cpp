#include <iostream>
#include <string>
#include <stack>
#include <vector>
using namespace std;

int main(void) {
	int n, i = 1;
	scanf("%d", &n);
	vector<string> answer;
	vector<int> array; // 만들어야하는 배열
	stack<int> temp; // 숫자 순서대로 넣는 배열
	for (int i=1; i<=n; i++) {
		int num;
		cin >> num;
		array.emplace_back(num);
	}
	temp.push(1);
	answer.emplace_back("+");
	while (temp.size() != 0 || i < n) {
		if (temp.size() != 0 && temp.top() == array[0]) {
			answer.emplace_back("-");
			temp.pop();
			array.erase(array.begin());
		}
		else if (temp.size() != 0 && i >= n) {
			break;
		}
		else {
			i++;
			temp.push(i);
			answer.emplace_back("+");
		}
	}

	if (array.size() == 0) {
		for (int i = 0; i < answer.size(); i++) cout << answer[i] << "\n";
	}
	else { cout << "NO\n"; }
}
