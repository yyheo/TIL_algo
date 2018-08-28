#include <iostream>
using namespace std;

int main() {
	int num, pass, count = 0;
	scanf("%d %d", &pass, &num);

	while (true) {
		count++;
		if (num == pass) break;
		num++;
	}
	
	printf("%d", count);
}
