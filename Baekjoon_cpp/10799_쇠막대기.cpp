#include <bits/stdc++.h>
using namespace std;

int main(void) {
	string input;
	cin >> input;
	int answer = 0, check = 0;
	for (int i = 0; i < input.size(); i++) {
		if (input[i] == '(') {
			check++; // 현재 깔려있는 쇠막대기 수 체크
		}
		else {
			if (input[i - 1] == '(') { // () 레이저일 경우
				check--;
				answer += check; // 잘린 쇠막대기 수만큼 더해줌
			}
			else { // 하나의 쇠막대기가 끝일 경우
				check--;
				answer++;
			}
		}
	}
	cout << answer;
}