#include <iostream>
#include <algorithm>
#include <math.h>
using namespace std;

int main() {
	int num, sum = 0;
	scanf("%d", &num);

	for (int i = 3; i >= 0; i--) {
		int a = pow(10, i);
		sum += num / a;
		num = num % a;
	}

	printf("%d", sum);

}
