#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

int solution(int n) {
	vector<bool> num(n + 1, true);
	for (int i = 2; i < sqrt(n); i++) { // n의 제곱근까지 배수인 수는 false로
		for (int j = i * 2; j <= n; j+=i) {
			num[j] = false;
		}
	}

	num[0] = false;
	num[1] = false; // 0, 1은 수동으로 걸러줌

	int answer = 0;
	for (int i = 0; i < num.size(); i++) {
		if (num[i] == true) answer++;
	}

	return answer;
}

int main(void) {
	cout << solution(10);
}


//에라토스테네스의 체 활용 문제
