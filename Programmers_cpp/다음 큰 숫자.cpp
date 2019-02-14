#include <iostream>
#include <string>
#include <vector>

using namespace std;
int solution(int n) {
	int temp = n;
	int scount = 0;
	while (temp > 1) {
		if (temp % 2 == 1) {
			scount++;
		}
		temp /= 2;
	}
	scount++;

	while (true) {
		n++;
		temp = n;
		int tempcount = 0;
		while (temp > 1) {
			if (temp % 2 == 1) {
				tempcount++;
			}
			temp /= 2;
		}
		tempcount++;

		if (tempcount == scount) break;
	}

	return n;
}

// 테스트 출력을 위한 코드
int main(void)
{
	cout << solution(78);
}
