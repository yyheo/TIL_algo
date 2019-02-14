#include <string>
#include <vector>
#include <math.h>

using namespace std;

int sum(int n) // 자릿수 합 함수
{
	int answer = 0;
	if (to_string(n).size() == 1) return n; // n이 한자리수면 n 리턴
	for (int i = to_string(n).size() - 1; i > 0; i--) { 
		int temp = pow(10, i);
		answer += n / temp;
		n = n % temp;
		if (i == 1) answer += n; // 1의 자리수만 남았으면 더해주기
	}

	return answer;
}

bool solution(int x) {
	if (x % sum(x) == 0) return true;
	else return false;
}

// 자릿수 더하기 
