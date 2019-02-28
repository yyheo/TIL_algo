#include <bits/stdc++.h>
using namespace std;

bool cmp(const string &a, const string &b) {
	string tmpAB = a + b, tmpBA = b + a;
	return atoi(tmpAB.c_str()) > atoi(tmpBA.c_str());
}

string solution(vector<int> numbers) {
	string answer = "";
	vector<string> temp;
	for (int i = 0; i < numbers.size(); i++) {
		temp.emplace_back(to_string(numbers[i]));
	}
	sort(temp.begin(), temp.end(), cmp);
	for (int i = 0; i < temp.size(); i++) { // string으로 반환값 만들어 줌
		answer += temp[i];
	}
	if (atoi(answer.c_str()) == 0) return "0"; // 전부 0이면 0 리턴
	return answer;
}

// 출력 테스트를 위한 코드
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);

	string answer = solution({ 0,0,0,0 });
	cout << answer;
}
