#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(string str) {
	int count = 0;

	for (int i = 0; i < str.length(); i++) {
		if (str[i] == ' ') {
			count = 0;
			continue;
		}
		if (count == 0 && str[i] >= 'a' && str[i] <= 'z') str[i] -= 32;
		else if (count != 0 && str[i] >= 'A' && str[i] <= 'Z') str[i] += 32;
		count++;
	}
	return str;
}

int main(void) {
	string answer = solution("AAAA  BBBB");
	cout << answer;
}
