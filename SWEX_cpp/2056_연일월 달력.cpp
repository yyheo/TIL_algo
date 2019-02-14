#include <iostream>
using namespace std;

int main() {
	int num;
	scanf("%d", &num);

	for (int i = 1; i <= num; i++) {
		int year, month, day;
		scanf("%4d%2d%2d", &year, &month, &day);
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (day <= 31 && day > 0) printf("#%d %04d/%02d/%02d\n", i, year, month, day);
			else printf("#%d -1\n", i);
			break;
		case 2:
			if (day <= 28 && day > 0) printf("#%d %04d/%02d/%02d\n", i, year, month, day);
			else printf("#%d -1\n", i);
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (day <= 28 && day > 0) printf("#%d %04d/%02d/%02d\n", i, year, month, day);
			else printf("#%d -1\n", i);
			break;
		default:
			printf("#%d -1\n", i);
		}
	}
}
