#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

bool desc(const pair<char, int>& a, const pair<char,int> &b) {
	if (a.second == b.second)
		return a.first > b.first; // 두번째 수가 같다면 첫번째 수로 내림차순
	return a.second > b.second; // 두번째 수가 더 큰 수가 앞으로
}

int main(void)
{
	string str;
	cin >> str;
	map <char, int> check;

	for (int i = 0; i < str.size(); i++) {
		if (str[i] >= 'a' && str[i] <= 'z') { // 소문자일 경우 대문자로 변환
			str[i] -= 32;
		}
		if (check.find(str[i]) == check.end()) { // map에 없는 경우
			check.insert(make_pair(str[i], 1));
		}
		else { // 있는 경우
			(check.find(str[i])->second)++;
		}
	}
	vector< pair< char, int > > vectorData;
	for (auto iter = check.begin(); iter != check.end(); ++iter) // map 정렬을 위해 vector로 변환시켜줌
		vectorData.push_back(make_pair(iter->first, iter->second));

	sort(vectorData.begin(), vectorData.end(), desc); // 내림차순으로 정렬

	if (vectorData.size() > 1 && vectorData[0].second == vectorData[1].second) { // 가장 많이 사용된 알파벳이 여러 개일 경우
		cout << "?";
	}
	else {
		cout << vectorData[0].first;
	}

}
