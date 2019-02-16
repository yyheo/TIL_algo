#include <bits/stdc++.h>

using namespace std;

int solution(vector<string> phone_book) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	map<string, bool> phone;

	for (int i = 0; i < phone_book.size(); i++) {
		phone[phone_book[i]] = true;
	}
	for (int i = 0; i < phone_book.size(); i++) {
		string s = "";
		for (int j = 0; j < phone_book[i].size() - 1; j++) {
			s += phone_book[i][j];
			auto it = phone.find(s);
			if (it != phone.end()) {
				return false;
			}
		}
	}
	return true;
}

// 출력 테스트를 위한 코드
int main(void) {
	bool answer = solution({ "119", "97674223", "1195524421"});
	cout << answer;
}