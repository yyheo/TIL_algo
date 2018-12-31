#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n) {
	vector<int> num(n + 1);
	num[0] = 0;
	num[1] = 1;

	for (int i = 2; i <= n; i++) {
		num[i] = (num[i - 2] + num[i - 1]) % 1234567;
	}

	return num[n];
}

int main(void) {
	cout << solution(3);
}

// 재귀로 풀 경우 runtime error
