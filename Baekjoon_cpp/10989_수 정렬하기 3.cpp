#include <iostream>
#include <cstring>
#include <cstdio>
#include <algorithm>
using namespace std;

int main(void)
{
	int N, num;
	scanf_s("%d", &N);
	int count[10001];
	memset(count, 0, sizeof(count));

	while (N--) {
		scanf_s("%d", &num);
		count[num]++;
	}

	for (int i = 1; i < 10001; i++) {
		for (int j = 0; j < count[i]; j++) {
			printf("%d\n", i);
		}
	}
}
