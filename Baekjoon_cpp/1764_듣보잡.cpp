#include <iostream>
#include <map>
#include <string>
using namespace std;
int main(void) {
	int sum = 0;
	map<string, int> answer;
	int N, M;
	string tmp;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		cin >> tmp;
		answer[tmp] = 1;
	}
	for (int i = 0; i < M; i++) {
		cin >> tmp;
		if (answer.find(tmp) != answer.end()) {
			answer[tmp] += 1;
			sum += 1;
		}
	}
	cout << sum << "\n";
	for (auto it = answer.begin(); it != answer.end(); it++) {
		if (it->second > 1) cout << it->first << "\n";
	}
}