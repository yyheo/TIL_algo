#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void)
{
	string str;
	getline(cin, str);
	int check = 0, num = 0;

	for (int i = 0; i < str.length(); i++) {
		if (str[i] == ' ') {
			check = 0;
		}
		else {
			check++;
		}

		if (check == 1) num++;
	}
	cout << num;
}
