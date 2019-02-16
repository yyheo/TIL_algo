#include <bits/stdc++.h>
using namespace std;

bool compare(tuple<string, int, int>& a, tuple<string, int, int>& b) {
	// 노래 정렬 수가 같다면
	if (get<1>(a) == get<1>(b))
		return get<2>(a) < get<2>(b); // 노래 고유번호로 오름차순
	return get<1>(a) > get<1>(b); // 노래 정렬수로 내림차순
}

vector<int> solution(vector<string> genres, vector<int> plays) {
	vector<int> answer;
	cin.tie(0);

	map <string, int> genCheck;
	map <int, string, greater<int>> reGenCheck;

	// 장르별 노래 재생 수 체크
	for (int i = 0; i < genres.size(); i++) {
		if (genCheck.find(genres[i]) != genCheck.end()) { // genCheck에 장르가 존재할 경우
			genCheck[genres[i]] += plays[i];
		}
		else { genCheck[genres[i]] = plays[i]; };
	}
	for (auto it = genCheck.begin(); it != genCheck.end(); it++) {
		reGenCheck[it->second] = it->first;
	}

	vector<tuple<string, int, int>> songs;
	for (int i = 0; i < genres.size(); i++) {
		songs.emplace_back(make_tuple(genres[i], plays[i], i));
	}

	// 재생 횟수, 고유 번호 순으로 정렬
	sort(songs.begin(), songs.end(), compare);

	// 많이 재생된 장르 순으로 수록
	for (auto it = reGenCheck.begin(); it != reGenCheck.end(); it++) { // 장르의 수만큼 반복
		int temp = 0;
		for (int j = 0; j < songs.size(); j++) {
			if (get<0>(songs[j]) == it->second) {
				answer.emplace_back(get<2>(songs[j]));
				temp++;
			}
			if (temp == 2) break;
		}
	}
	
	return answer;
}

// 출력 테스트를 위한 코드
int main(void) {
	vector<int> answer = solution({ "classic", "pop", "classic", "classic", "pop" }, { 500, 600, 150, 800, 2500 });
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i];
	}
}