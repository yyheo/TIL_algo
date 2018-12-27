#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
	vector<vector<int>> answer(arr1.size());
	int sum;

	for (int i = 0; i < arr1.size(); i++) {
		for (int j = 0; j < arr2[0].size(); j++) {
			sum = 0;
			for (int k = 0; k < arr1[0].size(); k++) {
				sum += arr1[i][k] * arr2[k][j];
			}
			answer[i].push_back(sum);
		}
	}
	return answer;
}

int main(void) {
	vector<vector<int>> answer = solution({ {1, 4} , {3, 2}, {4, 1} }, { {3, 3}, {3, 3} });
	for (int i = 0; i < answer.size(); i++) {
		for (int j = 0; j < answer[i].size(); j++) {
			cout << answer[i][j];
		}
	}
}
