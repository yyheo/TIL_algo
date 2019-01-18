#include <iostream>
#include <cmath>
#include <string>
#include <vector>
using namespace std;

vector<string> makeStar(int i, vector <string> star) {
	int bottom = 3 * pow(2, i);
	int middle = bottom / 2;

	for (int j = middle; j < bottom; ++j) {
		star[j] = star[j - middle] + " " + star[j - middle];
	}

	string space = " ";
	while (space.length() < middle) {
		space += " ";
	}
	for (int j = 0; j < middle; ++j) {
		star[j] = space + star[j] + space;
	}
	return star;
}


int main(void)
{
	int num;
	cin >> num;
	
	vector <string> star(num);
	star[0] = "  *  ";
	star[1] = " * * ";
	star[2] = "*****";

	for (int i = 1; 3 * pow(2, i) <= num; ++i) {
		star = makeStar(i, star);
	}

	for (int i = 0; i < num; ++i) {
		cout << star[i] << "\n";
	}

}
