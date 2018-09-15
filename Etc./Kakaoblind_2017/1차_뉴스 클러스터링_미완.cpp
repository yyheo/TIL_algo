#include <iostream>
#include <string>
#include <vector>
#include <cctype>

using namespace std;

void lowerString(string &str) {
	for (int i = 0; i < str.length(); i++) str[i] = tolower(str[i]);
}

bool checkEng(string &str) {
	for (int i = 0; i < str.length(); i++) {
		if (str[i] < 'a' || str[i] > 'z') return false;
	}
}

vector<string> devideString(string &str) {
	vector<string> stv;
	for (int i = 0; i < str.length() - 1; i++) {
		string strstr = str.substr(i, 2);
		if(checkEng(strstr)) stv.push_back(strstr);
	}
	return stv;
}

int solution(string str1, string str2) {
	int kyo = 0, hap = 0;
	vector<string> stv1, stv2;
	lowerString(str1);
	lowerString(str2);
	stv1 = devideString(str1);
	stv2 = devideString(str2);
	hap = stv1.size() + stv2.size();

	for (int i = 0; i < stv1.size(); i++) {
		for (int j = 0; j < stv2.size(); j++) {
			if (stv1[i] == stv2[j]) {
				kyo++;
				hap--;
			}
		}
	}

	float jakad = ((float)kyo / (float)hap)*65536;
	cout << jakad;
	
	return jakad;
}

int main() {
	solution("FRANCE", "french");

}
