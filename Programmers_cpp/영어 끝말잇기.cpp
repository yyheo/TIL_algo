#include <string>
#include <vector>
#include <string>
#include <vector>
#include <iostream>
#include <set>

using namespace std;

vector<int> solution(int n, vector<string> words) {
	vector<int> answer;
	vector<int> num(n, 0);
	set<string> wordCheck;
	pair<set<string>::iterator, bool> pr;
	bool check = false;
	for (int i = 0; i < words.size(); i++) {
		num[i % n] += 1;
		
		pr = wordCheck.insert(words[i]);
		if (check && words[i - 1].back() != words[i][0]) return { i % n + 1, num[i] }; // 조건 3
		if (!pr.second) return { i % n + 1, num[i % n] }; // 조건 4
		if (words[i].size() <= 1) return { i % n + 1, num[i] }; // 조건 5
		check = true;
	}
	return { 0, 0 };
}

int main(void) {
	solution(2, { "hello", "one", "even", "never", "now", "world", "draw" });
}