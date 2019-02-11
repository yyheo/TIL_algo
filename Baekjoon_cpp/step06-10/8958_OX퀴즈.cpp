#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void)
{
	int T;
	string OX;
	cin >> T;
	while (T--) {
		cin >> OX;
		int score = 0;
		int check = 0;
		for (int i = 0; i < OX.size(); i++) {
			if (OX[i] == 'O') {
				check++;
				score += check;
			}
			else {
				check = 0;
			}
		}
		cout << score << "\n";
	}
}
