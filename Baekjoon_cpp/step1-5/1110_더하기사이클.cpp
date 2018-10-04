#include <iostream>
#include <string>

using namespace std;

int main(void) {
	int first, num, numc = 0, count = 0; string numc_s;
	scanf("%d", &first);
	numc = first;

	while (!(numc == first) || count == 0) {
		num = numc;
		numc = (numc / 10) + (numc % 10);
		numc_s = to_string(num % 10) + to_string(numc % 10);
		numc = atoi(numc_s.c_str());
		count++;
	}
	cout << count;
}
