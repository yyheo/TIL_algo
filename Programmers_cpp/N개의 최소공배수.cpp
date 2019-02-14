#include <iostream>
#include <string>
#include <vector>
#include <math.h>
#include <algorithm>
#include <functional>

using namespace std;

int solution(vector <int> num) {
	int answer;
	int n = num[0];
	int m;
	for (int i = 1; i < num.size(); i++) {
		m = num[i];
		int max = (n > m) ? n : m;
		int min = (n < m) ? n : m;
		while (min != 0) { // 최대공약수 구하기, 유클리드 호제법
			int tem = max % min;
			max = min;
			min = tem;
		}
		answer = n * m / max; // 최소 공배수 = n * m / 최대공약수
		n = answer;
	}
	return answer;
}

int main(void) {
	int answer = solution({ 2,6,8,14 });
	cout << answer;
}
