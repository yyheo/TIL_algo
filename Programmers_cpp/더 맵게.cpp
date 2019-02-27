#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> prices, int K) {
	int answer = 0, sum = 0;
	priority_queue<int, vector<int>, greater<int>> food;
	for (int i = 0; i < prices.size(); i++) {
		food.push(prices[i]);
		sum += prices[i];
	}
	if (sum == 0 || (food.size() == 1 && sum < K)) return -1;
	while (food.top() < K) {
		if (food.size() == 1 && food.top() < K) return -1;
		int a = food.top();
		food.pop();
		food.push(a + food.top() * 2);
		food.pop();
		answer++;
	}
	return answer;
}

// 출력 테스트를 위한 코드
int main(void) {
	int answer = solution({ 0, 1 }, 7);
	cout << answer;
}
