#include <iostream>
using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int total, kim, im, answer = 0;
	cin >> total >> kim >> im;
	while (kim != im) {
		kim = kim / 2 + kim % 2;
		im = im / 2 + im % 2;
		answer += 1;
	}
	cout << answer;
	return 0;
}