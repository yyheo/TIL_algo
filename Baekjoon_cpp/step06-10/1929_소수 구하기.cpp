//에라토스테네스의 체 활용 문제

#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

vector<bool> sosu(int n) {
	vector<bool> num(n + 1, true);
	for (int i = 2; i <= sqrt(n); i++) { // n의 제곱근까지 배수인 수는 false로
		for (int j = i * 2; j <= n; j += i) {
			num[j] = false;
		}
	}
	num[0] = false;
	num[1] = false; // 0, 1은 수동으로 걸러줌
	return num;
}

int main(void) {
	int m, n;
	scanf("%d %d", &m, &n);
	vector<bool> answer = sosu(n);
	for (int i = m; i < answer.size(); i++) {
		if (answer[i] == true) printf("%d\n", i);
	}
}
