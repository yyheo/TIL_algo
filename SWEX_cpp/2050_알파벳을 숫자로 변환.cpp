#include <iostream>
#include <string>
using namespace std;

int main() {
	string str;

	cin >> str;

	for (int i = 0; i < str.size(); i++) {
		int su = str[i] - 64;
		printf("%d ", su);
	}
}
