#include <iostream>
using namespace std;

// 별찍기 - 1
//int main() {
//	int num;
//	scanf("%d", &num);
//	for (int i = 1; i <= num; i++) {
//		for (int j = 1; j <= i; j++) {
//			printf("*");
//		}
//		printf("\n");
//	}
//}

// 별찍기 - 2
//int main() {
//	int num;
//	scanf("%d", &num);
//	for (int i = 1; i <= num; i++) {
//		for (int j = 1; j <= num - i; j++) {
//			printf(" ");
//		}
//		for (int j = 1; j <= i; j++) {
//			printf("*");
//		}
//		printf("\n");
//	}
//}

// 별찍기 - 3
//int main() {
//	int num;
//	scanf("%d", &num);
//	for (int i = 0; i <= num; i++) {
//		for (int j = 0; j < num-i; j++) {
//			printf("*");
//		}
//		printf("\n");
//	}
//}

// 별찍기 - 4
int main() {
	int num;
	scanf("%d", &num);
	for (int i = 1; i <= num; i++) {
		for (int j = 1; j < i; j++) {
			printf(" ");
		}
		for (int j = 0; j <= num - i; j++) {
			printf("*");
		}
		printf("\n");
	}
}
