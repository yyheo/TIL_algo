#include <iostream>
#include <string>
using namespace std;
int main(void) {
	string str;
	int T;
	cin >> T;
	for (int i = 1; i <= T; i++) {
		cin >> str;
		bool check = false;
		string tmp = "";
		for (int j = 0; j < str.size(); j++) {
			if (j != 0 && str[j] == tmp[0]) {
				int jtmp = j;
				for (int k = 0; k < tmp.size(); k++) {
					if (str[jtmp++] == tmp[k]) {
						check = true;
					}
					else {
						check = false;
						break;
					}
				}
			}
			if (check == true) {
				cout << "#" << i << " " << tmp.size() << "\n";
				break;
			}
			tmp += str[j];
		}
	}
}