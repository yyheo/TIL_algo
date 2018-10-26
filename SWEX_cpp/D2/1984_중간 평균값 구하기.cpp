#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int main(void) {
	int N;
	cin >> N;
	for (int j = 0; j < N; j++) {
		double sum = 0;
		vector<int> num(10);

		for (int i = 0; i < num.size(); i++) {
			cin >> num[i];
		}

		int maxn, minn;
		maxn = *max_element(num.begin(), num.end());
		minn = *min_element(num.begin(), num.end());

		for (int i = 0; i < 10; i++) {
			if (num[i] != maxn && num[i] != minn) sum += num[i];
		}

		double ans = floor(sum / 8 + 0.5);
		cout << "#" << j+1 << " " << ans << "\n";
	}
}
