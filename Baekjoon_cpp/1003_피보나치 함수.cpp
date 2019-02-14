#include <iostream>
using namespace std;

int main(void) {
	int num;
	scanf("%d", &num);

	for (int i = 0; i < num; i++) {
		int tmp;
		scanf("%d", &tmp);

		int zero[41];
		int one[41];
		zero[0] = 1;
		zero[1] = 0;
		one[0] = 0;
		one[1] = 1;

		for (int i = 2; i < tmp + 1; i++) {
			zero[i] = zero[i - 1] + zero[i - 2];
			one[i] = one[i - 1] + one[i - 2];
		}

		cout << zero[tmp] << " " << one[tmp] << "\n";
	}
}