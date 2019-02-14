#include <iostream>
#include <string>
#include <deque>
using namespace std;

long long fibo[1500001];

int main(void) {
	long long num;
	scanf("%lld", &num);
	fibo[1] = 1;

	for (int i = 2; i <= 1500000; i++) {
		fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000;
	}

	cout << fibo[num % 1500000];
}