#include <iostream>
#include <vector>
using namespace std;

long N, B, C, ans = 0;
vector<int> A;

int main(void) {
	cin >> N;
	A.resize(N);

	for (int i = 0; i < N; i++) cin >> A[i];
	cin >> B >> C;

	for (int i = 0; i < N; i++) {
		A[i] -= B;
		ans++;

		if (A[i] > 0) {
			if (A[i] % C == 0) ans += A[i] / C;
			else ans += (A[i] / C) + 1;
		}
	}

	cout << ans;
}

/*
값 범위 잘 보기
범위가 1,000,000까지라 int가 아니라 long으로
*/
