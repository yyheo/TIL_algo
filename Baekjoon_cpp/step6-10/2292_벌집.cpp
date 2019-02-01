#include <iostream>
using namespace std;

int main(void)
{
	int N;
	cin >> N;
	int num = 1, check = 6;
	N -= 1;
	while (N > 0) {
		N -= check;
		num++;
		check += 6;
	}
	cout << num;
}
