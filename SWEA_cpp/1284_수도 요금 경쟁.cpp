#include <iostream>
using namespace std;
int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int T, A, B;
	int P, Q, R, S, W;
	cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		cin >> P >> Q >> R >> S >> W;
		A = W * P;
		B = W <= R ? Q : Q + (W - R) * S;
		if (A < B) cout << "#" << tc << " " << A << "\n";
		else cout << "#" << tc << " " << B << "\n";
	}
}