#include <iostream>
#include <string>
#include <vector>
#include <math.h>
#include <algorithm>
#include <functional>

using namespace std;

vector<int> solution(int n, int m) {
	vector<int> answer;
	int max = (n > m) ? n : m;
	int min = (n < m) ? n : m;

	while (min != 0) { // 최대공약수 구하기, 유클리드 호제법
		int tem = max % min;
		max = min;
		min = tem;
	}
	answer.push_back(max);
	answer.push_back(n * m / max); // 최소 공배수 = n * m / 최대공약수
	
	return answer;
}

int main(void) {
	vector<int> answer = solution(2, 5);
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i];
	}
}
