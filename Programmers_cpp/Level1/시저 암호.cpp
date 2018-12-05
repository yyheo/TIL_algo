#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

string solution(string s, int n) {
	for (int i = 0; i < s.size(); i++) {
		unsigned char tmp = s[i] + n; // unsigned를 붙여줘야 ASKII 코드 범위를 벗어날 때도 오류가 생기지 않음

		if (s[i] == ' ') { // 공백일경우
			s[i] = ' ';
		}

		else if ('a' <= s[i] && s[i] <= 'z') { // 소문자일 경우
			if (tmp > 'z') s[i] = 'a' + (tmp - 'z') - 1;
			else s[i] += n;
		}

		else if ('A' <= s[i] && s[i] <= 'Z') { // 대문자일 경우
			if (s[i] + n > 'Z') s[i] = 'A' + (tmp - 'Z') - 1;
			else s[i] += n;

		}
	}
	return s;
}

int main(void) {
	cout << solution("abcdefghijklmnopqrstuvwxyz", 25);
}
