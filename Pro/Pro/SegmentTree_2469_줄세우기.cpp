//// 정올 2469 줄세우기
//// 백준 2465 줄세우기
//#include <stdio.h>
//#define MAXN 100010
//int N;
//int people[MAXN], trr[MAXN];
//int cnt[MAXN], ans[MAXN];
//int tree[MAXN * 4];
//
//void mergeSort(int *arr, int s, int e) {
//	if (s >= e) return; // base
//	int m = (s + e) / 2; // divide
//	mergeSort(arr, s, m);
//	mergeSort(arr, m + 1, e);
//	int i = s, j = m + 1, k = s; // merge
//	for (k = s; k <= e; k++) {
//		if (j > e) trr[k] = arr[i++];
//		else if (i > m) trr[k] = arr[j++];
//		else if (arr[i] < arr[j]) trr[k] = arr[i++];
//		else trr[k] = arr[j++];
//	}
//	for (i = s; i <= e; i++) { // copy
//		arr[i] = trr[i];
//	}
//}
//
//// 모든 키의 개수의 합을 트리로 구성 (초기값은 모두 1)
//void build(int now, int s, int e) {
//	if (s == e) {
//		tree[now] = 1;
//		return;
//	}
//	int m = (s + e) / 2;
//	build(now * 2, s, m);
//	build(now * 2 + 1, m + 1, e);
//	tree[now] = tree[now * 2] + tree[now * 2 + 1]; // 구간합
//}
//
//// 자신보다 작은 학생 다음의 유효한 키를 구하고
//// 트리에서 제거
//void update(int now, int s, int e, int c, int idx) {
//	tree[now]--;
//	if (s >= e) { // 단말 노드
//		ans[idx] = people[s];
//		return;
//	}
//	int lch = now * 2, rch = now * 2 + 1, m = (s + e) / 2;
//	if (tree[lch] >= c) update(lch, s, m, c, idx);
//	else update(rch, m + 1, e, c - tree[lch], idx);
//}
//
//// 각 위치의 사람은 자신의 뒤에 있는 사람들의 키를 제외하고
//// 나머지 중에서 수열 S의 해당 위치 + 1번째 키이다.
//int main() {
//	int i;
//	scanf("%d", &N);
//	for (i = 1; i <= N; i++) scanf("%d", &people[i]);
//	for (i = 1; i <= N; i++) scanf("%d", &cnt[i]);
//	mergeSort(people, 1, N);
//	build(1, 1, N);
//	for (i = N; i > 0; i--) {
//		update(1, 1, N, cnt[i] + 1, i);
//	}
//	for (i = 1; i <= N; i++) printf("%d\n", ans[i]);
//	return 0;
//}