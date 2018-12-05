#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
	vector<vector<int>> stu = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 },{ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
	vector<int> score(3, 0);
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < answers.size(); j++) {
			if (answers[j] == stu[i][j % stu[i].size()]) score[i]++;
		}
	}
	int max = *max_element(score.begin(), score.end());
	vector<int> answer;
	for (int i = 0; i < 3; i++) if (score[i] == max) answer.push_back(i+1);
	sort(answer.begin(), answer.end());
	return answer;
}

int main(void) {
	vector<int> answer = solution({ 1, 2, 3, 4, 5 });

	for (int i = 0; i < answer.size(); i++) {
			cout << answer[i];
		}
	

}
