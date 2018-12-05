#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

string solution(string n) {
	int index = 0;
	for (int i = 0; i < n.size(); i++) {
		if (n[i] == ' ') { // 공백이면 index 초기화
			index = 0;
			continue;
		}
		if (index % 2 == 0 && n[i] >= 'a' && n[i] <= 'z') { // 짝수, 소문자일 경우 (대문자일 경우 변경 필요 X)
			n[i] = n[i] - 'a' + 'A';
		}
		else if (index % 2 == 1 && n[i] >= 'A' && n[i] <= 'Z') { // 홀수, 대문자일 경우 (소문자일 경우 변경 필요 X)
			n[i] = n[i] - 'A' + 'a';
		}
		index++;
	}
	return n;
}
int main(void) {
	cout << solution("try hello world");
}

// char 
