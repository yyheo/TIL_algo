#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int max(int a, int b, int c)
{
	int king = a;
	if (king<b) king = b;
	if (king<c) king = c;
	return king;
}

int solution(vector<vector<int> > land)
{
	int answer = 0;

	for (int i = 0; i < land.size() - 1; i++) {
		land[i + 1][0] += max(land[i][1], land[i][2], land[i][3]);
		land[i + 1][1] += max(land[i][0], land[i][2], land[i][3]);
		land[i + 1][2] += max(land[i][0], land[i][1], land[i][3]);
		land[i + 1][3] += max(land[i][0], land[i][1], land[i][2]);
	}
	answer = *max_element(land[land.size() - 1].begin(), land[land.size() - 1].end());
	return answer;
}

int main(void) {
	cout << solution({ {1,2,3,5}, {5,6,7,8}, {4,3,2,1} });
}
