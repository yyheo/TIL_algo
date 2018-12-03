#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(string s) {
	string answer = "";
	int num = s.length() / 2;
	if (s.length() % 2 == 0) {
		answer = s.substr(num - 1,2);
	}
	else {
		answer = s[num];
	}
	return answer;
}


int main(void) {
	string answer = solution("qwer");

	cout << answer;
}
