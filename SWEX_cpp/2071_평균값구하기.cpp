#include <iostream>
#include <math.h>
using namespace std;

int main() {
	int num;
	scanf("%d", &num);
	int n[100] = { 0 };

	for (int i = 0; i < num; i++) {
		int sum = 0;
		int avg = 0;
		for (int j = 0; j < 10; j++) {
			cin >> n[j];
			sum += n[j];

		}
		avg = sum / 10;
		if (sum % 10 >= 5)
			avg++;
		printf("#%d %d\n", i + 1, avg);
	}
}
