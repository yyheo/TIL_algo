//// 정올 1726 : 구간의 최대값1
//
//#include <stdio.h>
//#define MAXN 50010
//int N, Q;
//int A[MAXN];
//// 세그트리의 전체크기는 N * 4로
//int tree[MAXN * 4];
//
//inline int Max(int a, int b) { return a > b ? a : b; }
//
//// build (트리노드 번호, 구간 시작, 구간 끝)
//void build(int now, int s, int e) {
//	if (s == e) {			// s == e인 경우 : base condition
//		tree[now] = A[s];
//		return;
//	}
//	int lch = now * 2, rch = lch + 1, m = (s + e) / 2;
//	build(lch, s, m);		// 왼쪽 구간 트리 만들기
//	build(rch, m + 1, e);	// 오른쪽 구간 트리 만들기
//	tree[now] = Max(tree[lch], tree[rch]);	// 현재 노드 구간 업데이트
//}
//
//void buildTree() {
//	build(1, 1, N);
//}
//
//// update(트리노드 번호, 구간 시작, 구간 끝, 목표 위치, 업데이트할 값)
//void update(int now, int s, int e, int tgIdx, int val) {
//	if (s == e) { // s == e == tgIdx인 경우
//		tree[now] = val;
//		return;
//	}
//	int lch = now * 2, rch = lch + 1, m = (s + e) / 2;
//	if (tgIdx <= m) update(lch, s, m, tgIdx, val);	// 찾는 위치가 왼쪽
//	else update(rch, m + 1, e, tgIdx, val);			// 찾는 위치가 오른쪽
//	tree[now] = Max(tree[lch], tree[rch]);			// 현재 노드의 구간의 최대값 업데이트
//}
//
//// query (트리노드 번호, 구간 시작, 구간 끝, 질의구간 시작, 질의구간 끝)
//int query(int now, int s, int e, int fs, int fe) {
//	if (e < fs || fe < s) return 0;				// 트리 구간이 질의 구간에 포함 X
//	if (fs <= s && e <= fe) return tree[now];	// 트리 구간이 질의 구간에 포함 O
//	// 일부는 겹치고 일부는 겹치지 않음
//	int lch = now * 2, rch = lch + 1, m = (s + e) / 2;
//	int left = query(lch, s, m, fs, fe);
//	int right = query(rch, m + 1, e, fs, fe);
//	return Max(left, right);
//}
//
//int main(void) {
//	scanf("%d %d", &N, &Q);
//	// N개의 정수로 이루어진 수열 입력 (1 <= N <= 50000)
//	for (int i = 1; i <= N; i++) {
//		scanf("%d", A + i);
//	}
//	buildTree();
//	// Q개의 질의에 대한 답 구해서 출력 (1 <= Q <= 200000)
//	int a, b;
//	for (int i = 0; i < Q; i++) {
//		scanf("%d %d", &a, &b);
//		// 수열의 임의의 연속된 구간의 최대값 구해서 답
//		printf("%d\n", query(1, 1, N, a, b));
//	}
//}