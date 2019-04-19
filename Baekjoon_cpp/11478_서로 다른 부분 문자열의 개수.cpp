#include <iostream>
#include <string>
#include <set>
using namespace std;
int main(void) {
	set<string> check;
	string S;
	cin >> S;
	for (int i = 0; i < S.size(); i++) {
		for (int j = 1; j <= S.size(); j++) {
			check.insert(S.substr(i, j));
		}
	}
	cout << check.size();
}