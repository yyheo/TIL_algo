#include <iostream>
using namespace std;

int main() {
	int num;
	scanf("%d", &num);

	for (int i = 0; i <= num; i++) {
		printf("%d ", num-i);
	}
}
