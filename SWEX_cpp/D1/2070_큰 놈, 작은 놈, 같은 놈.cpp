#include <iostream>
#include <math.h>
using namespace std;

int main() {
	int num;
	scanf("%d", &num);

	for (int i = 0; i < num; i++) {
		int a, b;
		string bu;
		scanf("%d %d", &a, &b);
		if (a > b) printf("#%d >\n", i + 1);
		else if (a < b) printf("#%d <\n", i + 1);
		else if (a == b) printf("#%d =\n", i + 1);

	}
}
