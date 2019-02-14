#include <iostream>
#include <string>
#include <vector>
using namespace std;


void selfNumber(int num) {
	vector <bool> answer(10001, true);
	for (int i = 1; i <= 10000; i++) {
		int temp = i;
		int sum = 0;
		while (temp != 0) {
			sum += temp % 10;
			temp /= 10;
		}
		if (i+sum <=10000) answer[i + sum] = false;
	}

	for (int i = 1; i <= 10000; i++) {
		if (answer[i] == true) cout << i << "\n";
	}

}

int main(void)
{
	selfNumber(10000);
}
