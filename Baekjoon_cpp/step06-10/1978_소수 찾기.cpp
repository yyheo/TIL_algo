#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void)
{
	int N, sum = 0;
	cin >> N;
	while (N--) {
		int num;
		bool check = true;
		cin >> num;
		for (int i = num - 1; i > 1; i--) {
			if (num % i == 0) { // 자기보다 작은 수로 나눠질 경우 소수가 아닌걸로 체크
				check = false;
				break;
			}
		}
		if (num == 1) check = false; // 1은 소수가 아님
		if (check == true) sum++;
	}
	cout << sum;
}
