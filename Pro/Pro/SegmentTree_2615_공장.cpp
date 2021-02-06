//// 정올 2615 공장
//// 백준 7578 공장
//
//#include <stdio.h>
//#define MAXN 500010
//int N;
//int A[MAXN], B[MAXN];
//int arr[1000010];
//int tree[MAXN * 4];
//
//void add(int now, int s, int e, int num) {
//	tree[now]++;
//	if (s == e) return;
//	int m = (s + e) / 2;
//	if (num <= m) add(now * 2, s, m, num);
//	else add(now * 2 + 1, m + 1, e, num);
//}
//
//// 구간합
//int sum(int now, int s, int e, int qs, int qe) {
//	if (qs > e || s > qe) return 0;
//	if (qs <= s && e <= qe) return tree[now];
//	int m = (s + e) / 2;
//	return sum(now * 2, s, m, qs, qe) + sum(now * 2 + 1, m + 1, e, qs, qe);
//}
//
//int main(void) {
//	long long ans = 0;
//	int num, i;
//	scanf("%d", &N);
//	for (i = 1; i <= N; i++) {
//		scanf("%d", &num);
//		arr[num] = i;			// 식별번호 배열에 A배열의 위치 저장
//	}
//	for (int i = 1; i <= N; i++) {
//		scanf("%d", &num);
//		ans += sum(1, 1, N, arr[num], N);	// A열에 있는 숫자 ~ 맨 오른쪽까지 중 연결된 전선 갯수 구함 (구간합)
//		add(1, 1, N, arr[num]);				// 전선 연결
//	}
//	printf("%lld\n", ans);
//}
