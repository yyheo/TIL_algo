#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main(void)
{
	int X, num;
	cin >> X;
	int temp = X;
	for (int i = 1; temp > 0; i++) {
		temp -= i;
		num = i;
	}
	
	vector <string> arrnum(num);

	int index = 0; // index 계산
	for (int i = 0; i < num; i++) {
		index += i;
	}
	index = X - index - 1;

	
	if (num % 2 == 0) { // 짝수 행일 경우
		for (int i = 0; i < arrnum.size()/2; i++) {
			arrnum[i] = to_string(i + 1) + "/" + to_string(num);
			arrnum[arrnum.size() - i - 1] = to_string(num) + "/" + to_string(i + 1);
			num--;
		}
	}
	else { // 홀수 행일 경우
		for (int i = 0; i < arrnum.size()/2 + 1; i++) {
			arrnum[i] = to_string(num) + "/" + to_string(i + 1);
			arrnum[arrnum.size()-i-1] = to_string(i + 1) + "/" + to_string(num);
			num--;
		}
	}

	cout << arrnum[index];
}
