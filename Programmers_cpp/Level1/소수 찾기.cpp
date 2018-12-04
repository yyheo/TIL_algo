#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

int solution(int n) {
	vector<bool> num(n + 1, true);
	for (int i = 2; i < sqrt(n); i++) { // n의 제곱근까지 배수인 수는 false로
		for (int j = i * 2; j <= n; j+=i) {
			num[j] = false;
		}
	}

	num[0] = false;
	num[1] = false; // 0, 1은 수동으로 걸러줌

	int answer = 0;
	for (int i = 0; i < num.size(); i++) {
		if (num[i] == true) answer++;
	}

	return answer;
}

int main(void) {
	/*vector<string> answer = solution({"sun", "bed", "car"}, 1);*/

	cout << solution(10);

	//for (int i = 0; i < answer.size(); i++) {
	//	cout << answer[i];
	//}
}
