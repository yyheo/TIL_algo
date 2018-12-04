#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(vector<string> strings, int n) {
	sort(strings.begin(), strings.end()); // 먼저 sort 후
	for (int i = 0; i < strings.size(); i++) {
		for (int j = 0; j < strings.size() - 1; j++) { // 하나씩 bubble sort
			if (strings[j][n] > strings[j+1][n]) {
				string temp = strings[j+1];
				strings[j+1] = strings[j];
				strings[j] = temp;
			}
		}
	}
	return strings;
}

int main(void) {
	vector<string> answer = solution({"sun", "bed", "car"}, 1);

	//cout << answer;

	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i];
	}
}
