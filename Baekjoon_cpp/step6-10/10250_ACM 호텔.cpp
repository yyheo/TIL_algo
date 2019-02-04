#include <iostream>
#include <vector>
using namespace std;

int main(void)
{
	int T, H, W, N;
	cin >> T;
	while (T--) {
		cin >> H >> W >> N;

		int room, floor;
		room = N / H + 1;
		floor = N % H;

		if (floor == 0) {
			floor = H;
			room = N / H;
		}
		if (room < 10) cout << floor << "0" << room << "\n";
		else cout << floor << room << "\n";
	}
}
