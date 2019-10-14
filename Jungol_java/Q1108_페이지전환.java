import java.util.Arrays;
import java.util.Scanner;

public class Q1108_페이지전환 {
	static final int INF = 9999999;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] adjMatrix = new int[500][500];
		for (int i = 0; i < 500; i++) {
			Arrays.fill(adjMatrix[i], INF);
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			if (max < from) max = from;
			if (max < to) max = to;
			adjMatrix[from][to] = 1;
		}
		
		// 출발지 --> 경유지 --> 목적지로 3증 루프 돌리면 오답
		// 경유지 --> 출발지 --> 목적지로 3중 루프 돌려야 정답
		for (int k = 1; k <= max; ++k) {
			for (int i = 1; i <= max; i++) {
				if (i == k)	continue; // 출발지와 경유지가 같다면 다음 출발지
				for (int j = 1; j <= max; j++) {
					if(i==j || k==j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
					if(adjMatrix[i][k] + adjMatrix[k][j] < adjMatrix[i][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}
				}
			}
		}
		double sum = 0;
		double cnt = 0;
		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= max; j++) {
				if (adjMatrix[i][j] != INF) {
					cnt++;
					sum += adjMatrix[i][j];
				}
			}
		}
		sum = sum / (cnt);
		System.out.printf("%.3f", sum);
	}
}
