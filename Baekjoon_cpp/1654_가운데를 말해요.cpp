#include <iostream>
#include <queue>
using namespace std;
int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	priority_queue<int> ansFront;
	priority_queue<int, vector<int>, greater<int>> ansBack;
	int N, tmp;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> tmp;
		if (ansFront.empty()) ansFront.push(tmp);
		else if (tmp > ansFront.top()) ansBack.push(tmp);
		else ansFront.push(tmp);

		if (ansFront.size() > ansBack.size() + 1) {
			ansBack.push(ansFront.top()); ansFront.pop();
		}
		else if (ansBack.size() > ansFront.size()) {
			ansFront.push(ansBack.top()); ansBack.pop();
		}
		cout << ansFront.top() << "\n";
	}
}