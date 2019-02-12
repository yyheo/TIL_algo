#include <iostream>
#include <string>
#include <deque>
#include <algorithm>
using namespace std;

int main(void) {
	int T, n;
	scanf("%d", &T);
	while (T--) {
		string str, arr, tmp;
		cin >> str >> n >> arr;
		deque<int> deq;
		bool error = false, rev = false;
		for (int i = 0; i < arr.size(); i++) { // []형태로 주어지는 수를 deq에 입력
			if (n != 0 && (arr[i] == ',' || arr[i] == ']')) {
				deq.push_back(atoi(tmp.c_str()));
				tmp = "";
			}
			else if (arr[i] != '[') tmp += arr[i];
		}
		for (int i = 0; i < str.size(); i++) {
			if (str[i] == 'R') {
				rev = !rev;
			}
			else {
				if (deq.empty()) {
					error = true;
					break;
				}
				if (rev) deq.pop_back();
				else deq.pop_front();
			}
		}
		if (error) printf("error\n");
		else {
			printf("[");
			if(rev) reverse(deq.begin(), deq.end());
			while (!deq.empty()) {
				if (deq.size() != 1) {
					printf("%d,", deq.front());
					deq.pop_front();
				}
				else {
					printf("%d", deq.front());
					break;
				}
			}
			printf("]\n");
		}
	}
}
