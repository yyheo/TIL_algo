//에라토스테네스의 체 활용 문제

#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

int sosu(int n) {
	int answer = 0;
	vector<bool> num(2 * n + 1, true);
	for (int i = 2; i <= sqrt(n * 2); i++) { // n의 제곱근까지 배수인 수는 false로
		for (int j = i * 2; j <= n * 2; j += i) {
			num[j] = false;
		}
	}
	num[0] = false;
	num[1] = false; // 0, 1은 수동으로 걸러줌

	for (int i = n + 1; i < num.size(); i++) {
		if (num[i] == true) answer++;
	}
	return answer;
}

int main(void) {
	int n;
	while (true) {
		scanf("%d=", &n);
		if (n == 0) break;
		printf("%d\n", sosu(n));
	}
}
