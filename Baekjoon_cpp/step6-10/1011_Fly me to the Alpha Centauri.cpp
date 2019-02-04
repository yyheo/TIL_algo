#include <iostream>
#include <cstdio>
using namespace std;

int main(void)
{
	int T, x, y, dist;
	cin >> T;
	while (T--) {
		long long i, answer;
		cin >> x >> y;
		dist = y - x;

		for (long long i = 1;; i++) {
			if (dist > i * i - i && dist <= i * i + i) {
				if (dist <= i * i + i && dist > i * i) answer = i * 2;
				else answer = i * 2 - 1;
				break;
			}
		}

		cout << answer << "\n";
	}
}
