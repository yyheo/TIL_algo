#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(void) {
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		int N, num = 0, sum = 0, cnt = 0;
		long ans = 0;
		cin >> N;
		vector<int> price(N);
		for (int j = 0; j < N; j++) cin >> price[j];
		int max = *max_element(price.begin(), price.end());

		while (true) {
			while (price[num] != max) {
				sum += price[num];
				cnt += 1;
				num += 1;
			}
			ans += max * cnt - sum;
			if (num == price.size() - 1) break; //max값이 배열의 마지막이면 break
			else { //아니면 다시 계산
				num++;
				max = *max_element(price.begin()+num, price.end());
				sum = 0;
				cnt = 0;
			}
		}

		cout << "#" << i+1 << " " << ans << "\n";
	}
} // 7/10 Pail 에서 정답 타입 int -> long으로 바꾸니까 Pass
