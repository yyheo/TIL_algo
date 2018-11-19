#include <vector>
using namespace std;

long long solution(int N) {
	long long sum = 0;

	vector<bool> num(N+1, false);

	for (int i = 2; i <= N; i++) {
		if (num[i] == false) {
			sum += i;
			for (int j = i; j <= N; j += i) {
				num[j] = true;
			}
		}
	}

	return sum;
}
