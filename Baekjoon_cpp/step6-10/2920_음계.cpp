#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void)
{
	vector <int> music(9);
	for (int i = 1; i < music.size(); i++) {
		cin >> music[i];
	}
	int ascen = 0;
	int descen = 0;

	for (int i = 1; i < music.size(); i++) {
		if (i == music[i]) ascen++;
		else if (9 - i == music[i]) descen++;
		else break;
	}
	if (ascen == 8) cout << "ascending";
	else if (descen == 8) cout << "descending";
	else cout << "mixed";
}
