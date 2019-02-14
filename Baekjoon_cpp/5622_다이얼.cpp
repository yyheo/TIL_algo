#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void)
{
	int time = 0;
	string str;
	cin >> str;
	for (int i = 0; i < str.size(); i++) {
		if (str[i] >= 'P' && str[i] <= 'S') {
			time += 8;
		}
		else if (str[i] >= 'T' && str[i] <= 'V') {
			time += 9;
		}
		else if (str[i] >= 'W' && str[i] <= 'Z') {
			time += 10;
		}
		else {
			time += (str[i] - 65) / 3 + 3;
		}
	}
	cout << time;
}
