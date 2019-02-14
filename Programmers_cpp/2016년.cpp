#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
	vector<string> day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU", };
	vector<int> month = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	int num = 0;
	for (int i = 0; i < a-1; i++) {
		num += month[i];
	}
	num += b - 1;
	string answer = day[num % 7];
	return answer;
}

int main(void) {
	string answer = solution(5, 24);

	cout << answer;
}
