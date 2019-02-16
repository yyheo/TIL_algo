#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;

int main() {
	int no = 2;
	vector<int> works = { 3, 3, 3 };
	int answer = 0;

	for (int i = 0; i<no; i++) {
		int max = *max_element(works.begin(), works.end());
		for (int j = 0; j<works.size(); j++) {
			if (works[j] == max) {
				works[j]--;
				break;
			}
		}
	}
	for (int i = 0; i < works.size(); i++) {
		answer += pow(works[i], 2);
	}
	cout << answer;
}
