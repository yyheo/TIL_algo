#include <iostream>
#include <queue>
using namespace std;

int main(void) {
	int N, M;
	scanf("%d %d", &N, &M);
	queue<int> circle;
	queue<int> answer;
	for (int i = 1; i <= N; i++) circle.push(i);
	int check = 1;
	while (!circle.empty()) {
		if (check == M) {
			answer.push(circle.front());
			circle.pop();
			check = 1;
		}
		else {
			circle.push(circle.front());
			circle.pop();
			check++;
		}
	}
	// Ãâ·Â
	printf("<");
	for (int i = 0; i < N - 1; i++) {
		printf("%d, ", answer.front());
		answer.pop();
	}
	printf("%d", answer.front());
	printf(">");
}
