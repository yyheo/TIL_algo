import java.util.Scanner;

public class Solution {
	
	static int N, L, max = 0;
	static int[][] food;
	
	public static void DFS(int cur, int score, int cal) {
		if (cur + 1 > N || cal == L) {
			if (score > max) max = score;
			return;
		}
		if (cal + food[cur][1] <= L) DFS(cur + 1, score + food[cur][0], cal + food[cur][1]);
		DFS(cur + 1, score, cal);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T;

		T = scan.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			max = 0;
			N = scan.nextInt(); // 재료의 수
			L = scan.nextInt(); // 제한 칼로리
			food = new int[N][2];
			
			for (int i = 0; i < N; ++i) {
				food[i][0] = scan.nextInt(); // T, 재료의 점수
				food[i][1] = scan.nextInt(); // K, 재료의 칼로리
			}
			DFS(0, 0, 0);
			
			System.out.println("#" + tc + " " + max);
		}
	}
}
