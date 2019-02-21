#include <bits/stdc++.h>
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
	int answer = 0;
	int totWeight = 0;
	queue<int> bridgeTruck;
	queue<int> waitTruck;
	for (int i = 0; i < truck_weights.size(); i++) {
		waitTruck.push(truck_weights[i]);
	}
	for (int i = 0; i < bridge_length; i++) {
		bridgeTruck.push(0);
	}

	while (!(waitTruck.size() == 0 && totWeight == 0)) {
		answer++;
		totWeight -= bridgeTruck.front();
		bridgeTruck.pop();
		if (waitTruck.size() != 0 && totWeight + waitTruck.front() <= weight) { // 다리 위 트럭 총 합 + 다리를 건널 트럭의 무게 체크
			bridgeTruck.push(waitTruck.front());
			totWeight += waitTruck.front();
			waitTruck.pop();
		}
		else {
			bridgeTruck.push(0);
		}
	}
	return answer;
}

// 출력 테스트를 위한 코드
int main(void) {
	int answer = solution(100, 100, { 10,10,10,10,10,10,10,10,10,10 });
	cout << answer;
}
