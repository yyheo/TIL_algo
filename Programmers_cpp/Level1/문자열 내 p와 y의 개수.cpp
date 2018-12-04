#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool solution(string s)
{
	int pnum = 0, ynum = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == 'p' || s[i] == 'P') pnum++;
		else if (s[i] == 'y' || s[i] == 'Y') ynum++;
	}

	if (pnum == ynum || (pnum == 0 && ynum == 0)) return true;
	else return false;
}

int main(void) {
	cout << solution("abc");
}
