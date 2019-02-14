#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
	vector<int> answer;

	for (int i = 0; i < arr.size() - 1; i++) {
		if (arr[i] != arr[i + 1]) {
			answer.push_back(arr[i]);
		}
	}
	answer.push_back(arr[arr.size() - 1]);
	return answer;
}


int main(void) {
	vector<int> arr = { 4, 4, 4, 3, 3 };
	vector<int> answer = solution(arr);

	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i] << " ";
	}
}
