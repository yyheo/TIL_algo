#include <iostream>
using namespace std;

int main() {

	int T;
	scanf("%d", &T);

	for (int i = 0; i < T; i++) {
		int T_num, max = 0, max_num = 0;
		int num[1000], count[101] = { 0 };
		scanf("%d", &T_num);

		for (int j = 0; j < 1000; j++) {
			scanf("%d", &num[j]);
			count[num[j]]++;
		}
		
		for (int j = 0; j < 101; j++) {
			if (max <= count[j]) {
				max = count[j];
				max_num = j;
			}
		}

		printf("#%d %d\n", T_num, max_num);
	}

}
