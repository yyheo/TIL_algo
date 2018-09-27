#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
	map<string, int> mm;
	string answer = "";

	for (int i = 0; i<participant.size(); i++) mm[participant[i]]++;
	for (int i = 0; i<completion.size(); i++) mm[completion[i]]--;
	for (auto it = mm.begin(); it != mm.end(); it++) {
		if (it->second != 0) answer = it->first;
	}

	return answer;
}

void main() {
	vector<string> participant = { "leo", "kiki", "eden" };
	vector<string> completion = { "eden", "kiki" };

	cout << solution(participant, completion);
}
