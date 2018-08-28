#include <iostream>
using namespace std;

int main() {
	int T, num[5] = { 2,3,5,7,11 };
	scanf("%d", &T);

	for (int i = 1; i <= T; i++) {
		int t_num, count = 0;
		scanf("%d", &t_num);
		printf("#%d ", i);
		for (int j = 0; j < 5; j++) {
			if (t_num % num[j] == 0) {
				count++;
				t_num /= num[j];
				j--;
			}
			else {
				printf("%d ", count);
				count = 0;
			}
		}
		printf("\n");
	}
}
