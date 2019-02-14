#include <iostream>
using namespace std;

// 11721_열 개씩 끊어 출력하기
int main() {
	char str[100] = { 0 };
	cin >> str;
	for (int i = 0; i < 100; i++) {
		if (str[i] == NULL) break;
		else if (i%10 == 0 && i != 0) cout << endl;
		cout << str[i];
	}
}

