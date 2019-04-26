#include <iostream>
#include <vector>
using namespace std;
int main(void) {
	int T, N, M, max;
	cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		cin >> N >> M;
		max = -1;
		vector<vector<int>> pari(N, vector<int>(N));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) cin >> pari[i][j];
		}
		for (int i = 0; i <= N - M; i++) {
			for (int j = 0; j <= N - M; j++) {
				int sum = 0;
				for (int y = i; y < i + M; y++) {
					for (int x = j; x < j + M; x++) {
						sum += pari[y][x];
					}
				}
				if (sum > max) max = sum;
			}
		}
		cout << "#" << tc << " " << max << "\n";
	}
}