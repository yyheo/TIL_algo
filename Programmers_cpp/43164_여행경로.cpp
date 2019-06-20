#include <iostream>
#include <string>
#include <string.h>
#include <vector>
#include <algorithm>
using namespace std;
int visit[10001];
vector<string> tmp;

int dfs(int start, int n, vector<vector<string>> tickets) {
	visit[start] = 1;
	tmp.push_back(tickets[start][0]);
	if (tmp.size() == n) { // ÀüºÎ Å½»ö
		tmp.push_back(tickets[start][1]);
		cout << tmp.size() << " " << n << " " << tickets[start][1] << " ";
		return 0;
	}
	for (int i = 0; i < tickets.size(); i++) {
		if (tickets[start][1] == tickets[i][0] && !visit[i]) {
			dfs(i, n, tickets);
		}
	}
}

vector<string> solution(vector<vector<string>> tickets) {
	vector<vector<string>> answer;
	for (int i = 0; i < tickets.size(); i++) {
		if (tickets[i][0] == "ICN") {
			tmp.clear();
			memset(visit, 0, sizeof(visit));
			dfs(i, tickets.size(), tickets);
			answer.push_back(tmp);
		}
	}
	sort(answer.begin(), answer.end());
	return answer[0];
}
int main() {
	vector<string> answer = solution({ { "ICN", "SFO" },{ "ICN", "ATL" },{ "SFO", "ATL" },{ "ATL", "ICN" },{ "ATL", "SFO" } });
	return 0;
}