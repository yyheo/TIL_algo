// DP

#include <iostream>
#include <string>
#include <vector>
using namespace std;

int _MIN(int a, int b, int c)
{
	return (a > b) ? ((b > c) ? c : b) : ((a > c) ? c : a);
}

int solution(vector<vector<int>> v) {
	int answer = 0;
	vector<int> ans;
	for (int i = 0; i < v.size(); i++) {
		for (int j = 0; j < v[i].size(); j++) {
			if (v[i][j] == 1 && i != 0 && j != 0) {
				v[i][j] = _MIN(v[i - 1][j], v[i][j - 1], v[i - 1][j - 1]) + 1;
			}
			answer = (answer < v[i][j]) ? v[i][j] : answer;
		}
	}
	return answer * answer;
}

// 테스트 출력을 위한 코드
int main(void)
{
	cout << solution({ {1,1,1,1}, {1,0,0,0}, {1,0,0,0}, {1,0,0,0} });
}
