#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

bool solution(vector<int> arr) {
	bool answer = true;
	int num = 0;
	sort(arr.begin(), arr.end());

	for (int i = 1; i <= arr.size(); i++) {
		if (arr[i - 1] == i) answer = true;
		else answer = false;
	}
		return answer;
}
