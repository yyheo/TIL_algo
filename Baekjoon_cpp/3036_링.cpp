#include <iostream>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N, ring, ring2, tmp;
	cin >> N >> ring;
	for (int i = 0; i < N - 1; i++) {
		cin >> ring2;
		tmp = (ring > ring2 ? ring2 : ring);
		while ((ring % tmp) != 0 || (ring2 % tmp) != 0) {
			tmp -= 1;
		}
		cout << ring / tmp << "/" << ring2 / tmp << "\n";
	}
	return 0;
}