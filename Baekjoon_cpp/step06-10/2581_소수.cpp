#include <iostream>
using namespace std;

int main(void)
{
	int M, N, minN = -1, sum = 0;
	cin >> M >> N;
	for (int num=N; num>=M; num--) {
		bool check = true;
		for (int i = num - 1; i > 1; i--) {
			if (num % i == 0) { // 자기보다 작은 수로 나눠질 경우 소수가 아닌걸로 체크
				check = false;
				break;
			}
		}
		if (num == 1) check = false; // 1은 소수가 아님
		if (check == true) {
			sum += num; // 소수일 경우 sum에 더해줌
			minN = num;
		}
	}
	if (minN != -1) cout << sum << "\n" << minN;
	else cout << minN;
}
