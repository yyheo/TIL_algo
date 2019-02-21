#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
	vector<int> answer;
	int sum = 0;
	while (true) {
		int check = 0;
		for (int i = sum; i < progresses.size(); i++) {
			progresses[i] += speeds[i];
		}
		for (int i = sum; i < progresses.size(); i++) {
			if (progresses[i] >= 100) check++;
			else break;
		}
		if (check != 0) answer.emplace_back(check);
		sum += check;
		if (sum == progresses.size()) break;
	}
	return answer;
}

// 출력 테스트를 위한 코드
int main(void) {
	vector<int> answer = solution({ 93,30,55 }, { 1,30,5 });
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i];
	}
}
