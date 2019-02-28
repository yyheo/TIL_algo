#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> citations) {
	int answer, i;
	sort(citations.begin(), citations.end(), greater<int>());
	citations[0] < citations.size() ? i = citations[0] : i = citations.size();
	while (i >= 0) {
		int check = 0;
		for (int j = 0; j < citations.size(); j++) {
			if (citations[j] >= i) {
				check++;
			}
			else { break; }
		}
		if (check >= i) return i;
		i--;
	}
}

int main(void) {
	cout << solution({ 22,42 });
}