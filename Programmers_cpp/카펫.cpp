#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int brown, int red) {
	int bx, by, sum = brown + red;
	for (by = 1; by <= sqrt(sum); by++) {
		bx = sum / by;
		if ((bx - 2) * (by - 2) == red) return { bx, by };
	}
}

int main(void) {
	vector<int> answer = solution( 8, 1 );
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i];
	}
}