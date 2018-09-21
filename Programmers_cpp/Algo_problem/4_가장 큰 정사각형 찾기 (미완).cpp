#include <iostream>
#include <vector>
#include <algorithm>
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
			if (i != 0 && j != 0) v[i][j] = _MIN(v[i - 1][j], v[i][j - 1], v[i - 1][j - 1]) + v[i][j];
			answer = (answer < v[i][j]) ? v[i][j] : answer;
		}
	}
	return answer * answer;
}

/*
(미완)
채점 결과
정확성: 40.8
효율성: 13.5
합계: 54.3 / 100.0
*/
