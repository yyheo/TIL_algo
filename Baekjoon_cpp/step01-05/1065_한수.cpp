#include <iostream>
#include <string>
#include <vector>
using namespace std;

int hanSu(int num) {
	int count = 0;

	for (int i = 1; i <= num; i++) {
		if (i < 10) {
			count++;
		}
		else if (i < 100) {
			count++;
		}
		else if (i < 1000) {
			vector <int> temp;
			int tempnum = i;
			while (tempnum != 0) {
				temp.emplace_back(tempnum % 10);
				tempnum /= 10;
			}
			if (temp[0] - temp[1] == temp[1] - temp[2]) {
				count++;
			}
		}
	}

	return count;
}

int main(void)
{
	int num;
	cin >> num;
	cout << hanSu(num);
}
