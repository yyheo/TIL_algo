#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void)
{
	int A, B, C;
	vector <int> check(10, 0);
	cin >> A >> B >> C;
	int num = A * B * C;
	int n;
	while (num != 0) {
		n = num % 10; // A * B * C의 각 자리수 뽑아내기
		check[n] ++; // 뽑아낸 각 자리수의 인덱스에 +1
		num /= 10;
	}
	for (int i = 0; i < check.size(); i++) {
		cout << check[i] << "\n";
	}
}
