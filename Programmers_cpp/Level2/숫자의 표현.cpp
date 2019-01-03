#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int n) {
	int answer = 0;

	for (int i = 1; i <= n; i++) {
		int sum = 0;
		sum += i;
		if (sum < n) {
			for (int j = i + 1; j <= n; j++) {
				sum += j;
				if (sum == n) {
					answer++;
					break;
				}
				else if (sum > n) {
					break;
				}
			}
		}
		else if (sum == n) {
			answer++;
		}
		else {
			return answer;
		}
	}
	return answer;
}

int main(void) {
	cout << solution(15);
}
