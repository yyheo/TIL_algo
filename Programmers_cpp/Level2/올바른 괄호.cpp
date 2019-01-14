#include<string>
#include <iostream>
using namespace std;

bool solution(string s)
{
	int check = 0;

	for (int i = 0; i < s.size(); i++) {
		if (s[i] == '(' && check >= 0) check++;
		else if (s[i] == ')') check--;
	}

	if (check == 0) return true;
	else return false;
}

// 출력 테스트를 위한 코드
int main(void)
{
	cout << solution("())())");
}
