#include <iostream>
using namespace std;

int main(void)
{
	int T, H, W, N;
	cin >> T;
	while (T--) {
		cin >> H >> W >> N;

		int a, b;
		a = N / H + 1;
		b = N % H;

		if (b == 0) {
			b = H;
			a = N / H;
		}
		if (a < 10) cout << b << "0" << a << "\n";
		else cout << b << a << "\n";
	}
}
