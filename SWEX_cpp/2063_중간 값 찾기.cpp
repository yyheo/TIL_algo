#include <iostream>
#include <algorithm>
#include <math.h>
using namespace std;

int main() {
	int a[200] = { };
	int num;
	scanf("%d", &num);

	for (int i = 0; i < num; i++) {
		cin >> a[i];
	}
	sort(a, a + num);
	printf("%d", a[(num / 2)]);
}
