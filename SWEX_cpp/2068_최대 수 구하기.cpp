#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int num[10] = {  };
	int n, max = 0;
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 10; j++) {
			cin >> num[i];
			if (num[i] > max) max = num[i];
		}
		printf("#%d %d\n", i+1, max);
		max = 0;
	}
}
