#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void)
{
	vector<string> croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
	int pos;
	string str;
	cin >> str;
	for (int i = 0; i < croatia.size(); i++) { // 크로아티아 수를 하나의 알파벳으로 바꿔줌
		while ((pos = str.find(croatia[i])) != string::npos) {
			str.erase(pos, croatia[i].size());
			str.insert(pos, "a");
		}
	}
	cout << str.length();
}
