#include <iostream>
#include <vector>
using namespace std;
int main(void) {
	int T, N;
	cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		cin >> N;
		vector<vector<int>> pascal(N, vector<int>(N, 0));
		cout << "#" << tc << "\n";
		for (int i = 0; i < pascal.size(); i++) {
			for (int j = 0; j < i + 1; j++) {
				if (i < 1 || j < 1 || j >= i + 1) pascal[i][j] = 1;
				else pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
				cout << pascal[i][j] << " ";
			}
			cout << "\n";
		}
	}
}