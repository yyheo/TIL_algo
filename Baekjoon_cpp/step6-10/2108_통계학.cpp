#include <iostream>
#include <cstdio>
#include <vector>
#include <map>
#include <algorithm>
#include <cmath>
using namespace std;

bool compare(const pair<int, int>&a, const pair<int, int>&b)
{
	return a.second<b.second;
}

int main(void)
{
	int N, tmp;
	double sum = 0;
	scanf("%d", &N);
	vector<int> number;
	map<int, int> count;

	for (int i = 0; i < N; i++) {
		scanf("%d", &tmp);
		sum += tmp; // 산술평균을 구하기 위한 합
		number.emplace_back(tmp);
		if (count.find(tmp) == count.end()) { // map에 key가 없을 경우
			count.insert(make_pair(tmp, 1));
		}
		else {
			count[tmp]++;
		}
	}
	// 산술평균
	int avg = floor(sum / N + 0.5);
	printf("%d\n", avg);
	// 중앙값
	sort(number.begin(), number.end());
	printf("%d\n", number[N / 2]);
	// 최빈수
	int maxn = max_element(count.begin(), count.end(), compare)->second; // 제일 많이 등장한 횟수 얻기
	map<int, int>::iterator iter;
	vector<int> check;
	for (iter = count.begin(); iter != count.end(); ++iter) { // 최빈수일 경우 check vector에 넣어줌
		if ((*iter).second == maxn) check.emplace_back((*iter).first);
	}
	if (check.size() > 1) { // 최빈수 값이 여러개일 경우
		sort(check.begin(), check.end());
		printf("%d\n", check[1]);
	} else printf("%d\n", check[0]);
	// 범위
	printf("%d\n", abs(number[0] - number[number.size()-1]));
}
