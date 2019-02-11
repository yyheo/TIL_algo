#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void)
{
	int a, b, reA = 0, reB = 0;
	cin >> a >> b;

	while (a) {
		reA = (reA * 10) + (a % 10);
		a = a / 10;
	}
	while (b) {
		reB = (reB * 10) + (b % 10);
		b = b / 10;
	}

	if (reA > reB) cout << reA;
	else cout << reB;
}

// 
