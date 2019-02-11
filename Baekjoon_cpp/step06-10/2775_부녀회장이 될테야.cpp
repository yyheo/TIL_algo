#include <iostream>
#include <vector>
using namespace std;

int main(void)
{
	int T, k, n;
	cin >> T;
	while (T--) {
		cin >> k >> n;
		vector < vector<int> > apart(k + 1, vector<int>(n + 1));
		for (int i = 1; i <= n; i++) {
			apart[0][i] = i;
		}
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				apart[i][j] = apart[i][j - 1] + apart[i - 1][j];
			}
		}
		cout << apart[k][n] << "\n";
	}
}
