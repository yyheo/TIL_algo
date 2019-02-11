//에라토스테네스의 체 활용 문제

#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

int sosu(int n) {
	vector<bool> num(n + 1, true);
	for (int i = 2; i <= sqrt(n * 2); i++) { // n의 제곱근까지 배수인 수는 false로
		for (int j = i * 2; j <= n; j += i) {
			num[j] = false;
		}
	}
	num[0] = false;
	num[1] = false; // 0, 1은 수동으로 걸러줌

	for (int i = n/2; i > 0; i--) {
		if (num[i] == true && num[n - i] == true) {
			printf("%d %d\n", i, n - i);
			break;
		}
	}
	return 0;
}

int main(void) {
	int T, n;
	scanf("%d", &T);
	while (T--) {
		scanf("%d", &n);
		sosu(n);
	}
}
