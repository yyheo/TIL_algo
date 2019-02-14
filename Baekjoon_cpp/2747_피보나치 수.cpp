#include <iostream>
#include <string>
using namespace std;

int main(void) {
	int num;
	scanf("%d", &num);
	int a = 0, b = 1;

	for (int i = 2; i < num + 1; i++) {
		int temp = b;
		b = a + b;
		a = temp;
	}

	if (num == 0) cout << a;
	else cout << b;
}