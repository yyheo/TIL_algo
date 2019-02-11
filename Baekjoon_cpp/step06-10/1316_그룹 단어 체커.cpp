#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main(void)
{
	int N;
	cin >> N;
	int check = 0;
	bool word;
	for (int i = 0; i < N; i++) {
		word = true;
		string str;
		cin >> str;
		vector <bool> alp(26, false);
		for (int j = 0; j < str.size(); j++) {
			if (alp[str[j] - 97] == false) { // 해당 알파벳이 처음 등장했을 경우 체크
				alp[str[j] - 97] = true;
			}
			else if (alp[str[j] - 97] == true) {
				if (str[j - 1] != str[j]) { // 해당 알파벳이 이미 나왔는데 이어지지 않았을 경우 잘못된 word로 체크
					word = false;
					break;
				}
			}
		}
		if (word == true) // 정상적인 word일 경우 갯수 +1
			check++;
	}
	cout << check;

}
