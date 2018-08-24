#include <iostream>
using namespace std;
int main() {
	int num;
	scanf("%d", &num);
	int n[100] = { 0 };
	for (int i = 0; i < num; i++) {
		int sum = 0;
		for (int j = 0; j < 10; j++) {
			cin >> n[j];
			if (n[j] % 2 == 1) sum += n[j];
		}
		printf("#%d %d\n", i+1, sum);
	}
}
