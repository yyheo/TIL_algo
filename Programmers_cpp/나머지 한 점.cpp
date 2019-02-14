#include <iostream>
#include <vector>
using namespace std;

vector<int> solution(vector<vector<int>> v) {
	vector<int> ans(2);

	ans[0] = v[0][0] ^ v[1][0] ^ v[2][0];
	ans[1] = v[0][1] ^ v[1][1] ^ v[2][1];

	return ans;
}

int main() {
	vector<vector<int>> arr = { { 1, 4 }, { 3, 4 }, { 3, 10 } };
	vector<int> ans = solution(arr);

	for (int i = 0; i < ans.size(); i++) {
		cout << ans[i];
	}
}
