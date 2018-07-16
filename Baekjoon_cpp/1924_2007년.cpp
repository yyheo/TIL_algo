#include <iostream>
#include <string>
using namespace std;
int month[12] = { 31,28,31,30,31,30,31,31,30,31,30,31 };
string day[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

int main() {
	int x, y;
	int num = 0;

	scanf("%d %d", &x, &y);
	for (int i = 0; i < x - 1; i++) {
		num += month[i];
	}
	num += y;

	cout << day[num%7];
}
