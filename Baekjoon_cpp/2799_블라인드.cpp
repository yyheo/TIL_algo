#include <iostream>
#include <vector>
#include <string>
using namespace std;
int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int answer[5] = { 0, };
	int M, N;
	cin >> M >> N;
	vector<string> apart(5*M + 1);
	for (int i = 0; i < 5 * M + 1; ++i) {
		cin >> apart[i];
	}
	for (int i = 5 * M; i >= 0; --i) {
		for (int j = 1; j < apart[i].size(); j = j + 5) {
			if (apart[i][j] == '*' && (apart[i+1][j] == '.' || apart[i + 1][j] == '#')) {
				answer[i % 5] += 1;
			}
			else if (i % 5 == 1 && apart[i][j] == '.') answer[0] += 1; // 창문 다 닫혀있을 경우
			else if (apart[i][j] == '#') break; // 창문 영역이 아닐 경우
		}
	}
	for (int i = 0; i < 5; i++) {
		cout << answer[i] << " ";
	}
}