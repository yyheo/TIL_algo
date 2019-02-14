#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(vector<string> seoul) {
	int i;
	for (i = 0; i<seoul.size(); i++) {
		if (seoul[i] == "Kim") break;
	}
	string answer = "김서방은 " + to_string(i) + "에 있다";
	return answer;
}

int main(void) {
	string answer = solution({ "Jane", "Kim" });

	cout << answer;

	//for (int i = 0; i < answer.size(); i++) {
	//	cout << answer[i];
	//}
}
