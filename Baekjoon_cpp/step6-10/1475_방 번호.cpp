#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
using namespace std;

int main(void)
{
	string N;
	cin >> N;
	vector<int> number (10);
	for (int i = 0; i < N.size(); i++) {
		if (N[i] == '9') N[i] = '6';
		int index = N[i] - '0';
		number[index]++;
	}
	number[6] = floor((number[6]) / 2.0 + 0.5);
	cout << *max_element(number.begin(), number.end());
}
