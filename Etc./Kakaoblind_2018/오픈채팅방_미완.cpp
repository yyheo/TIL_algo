#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <map>

using namespace std;

vector<string> solution(vector<string> record) {
	map<string, string> user;
	string event, uid, uname;
	vector<string> answer;

	for (int i = 0; i < record.size(); i++) {
		stringstream ss;
		ss.str(record[i]);
		ss >> event;
		ss >> uid;
		ss >> uname;

		user[uid] = uname;
	}

	for (int i = 0; i < record.size(); i++) {
		stringstream ss;
		ss.str(record[i]);
		ss >> event;
		ss >> uid;

		if (event == "Enter") answer.push_back(user[uid] + "님이 들어왔습니다.");
		else if (event == "Leave") answer.push_back(user[uid] + "님이 나갔습니다.");
	}

	return answer;
}

void main() {
	vector<string> record = { "Enter uid1234 Muzi", "Enter uid2345 Muzi", "Leave uid1234", "Enter uid1234 ZZZ", "Change uid1234 aaa", "Leave uid1234"};
	vector<string> answer = solution(record);

	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i];
	}
	
}
