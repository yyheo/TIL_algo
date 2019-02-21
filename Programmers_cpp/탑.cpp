#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> heights) {
	vector<int> answer;
	answer.emplace_back(0);
	for(int i = 1; i < heights.size(); i++) {
		for (int j = i-1; j >= 0; j--) {
			if (heights[i] < heights[j]) {
				answer.emplace_back(j+1);
				break;
			}
			else if (j == 0) answer.emplace_back(0);
		}
	}
	return answer;
}

// 출력 테스트를 위한 코드
int main(void) {
	vector<int> answer = solution({ 6,9,5,7,4});
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i];
	}
}
