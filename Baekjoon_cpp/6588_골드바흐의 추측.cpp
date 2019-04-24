#include <iostream>
#include <vector>
using namespace std;
int num[1000001];

void sosu() {
	num[0] = 1;
	num[1] = 1;
	for (int i = 2; i * i <= 1000000; i++) {
		if (num[i] == 0) {
			for (int j = i * 2; j <= 1000000; j += i) {
				num[j] = 1; // 소수가 아니면 1로 체크
			}
		}
	}
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	sosu();
	int n = 1;
	while (n != 0) {
		cin >> n;
		bool check = false;
		for (int i = 0; i <= n; i++) {
			if (num[i] == 1) continue;
			if (num[n - i] == 1) continue;
			cout << n << " = " << i << " + " << n - i << "\n";
			break;
		}
	}
}