#include <iostream>
#include <string>
#include <vector>

using namespace std;

long long solution(int a, int b) {
	long sum = 0;
	if (a>b) {
		for (int i = a; i >= b; i--) sum += i;
	}
	else {
		for (int i = a; i <= b; i++) sum += i;
	}
	long long answer = sum;
	return answer;
}

int main(void) {
	int answer = solution(-1,1);

	cout << answer;
  }
}
