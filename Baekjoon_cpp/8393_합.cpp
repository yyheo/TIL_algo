#include <iostream>
using namespace std;

//8393 합
int main() {
	int num, sum = 0;
	scanf("%d", &num);

	for (int i = 1; i <= num; i++) {
		sum += i;
	}

	cout << sum;
}
