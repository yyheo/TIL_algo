// 탐욕법 (Greedy)

#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
	vector<int> stu(n, 1);
	for (int i = 0; i < reserve.size(); i++) { // 체육복 여벌 챙겨온 학생
		stu[reserve[i] - 1]++;
	}
	for (int i = 0; i < lost.size(); i++) { // 체육복 도난당한 학생
		stu[lost[i] - 1]--;
	}
	for (int i = 0; i < stu.size(); i++) { // 앞, 뒤 학생이 체육복이 0이라면 나눠주기 (첫, 마지막 학생 제외)
		if ((i > 0) && (stu[i] > 1) && (stu[i - 1] == 0)) {
			stu[i]--;
			stu[i - 1]++;
		} else if ((i < stu.size()-1) && (stu[i] > 1) && (stu[i + 1] == 0)) {
			stu[i]--;
			stu[i + 1]++;
		}
	}

	int answer = 0;
	for (int i = 0; i < stu.size(); i++) { // 체육복 1개 이상인 학생 체크
		if (stu[i] > 0) answer++;
	}

	return answer;
}

int main(void) {
	cout << solution(5, { 2, 4 }, { 2, 3, 5 });
}
