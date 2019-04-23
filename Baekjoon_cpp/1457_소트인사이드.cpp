#include <iostream>
#include <string>
#include <algorithm>
#include <functional>
using namespace std;

int main(void)
{
	string num;
	cin >> num;
	sort(num.begin(), num.end(), greater<int>());
	cout << num;
}