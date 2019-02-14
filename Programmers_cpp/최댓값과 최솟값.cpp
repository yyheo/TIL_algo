#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

string solution(string s) {
	vector <int> num;
	string buf;
	stringstream ss(s);
	while (ss >> buf) num.push_back(stoi(buf));

	int max = *max_element(num.begin(), num.end());
	int min = *min_element(num.begin(), num.end());

	string answer = to_string(min) + " " + to_string(max);
	return answer;
}

int main(void) {
	cout << solution("1 2 3 4");
}
