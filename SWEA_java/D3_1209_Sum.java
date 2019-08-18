import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class D3_1209_Sum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[100][100];
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); 	// 테케 번호 날리기
			// 합을 저장할 배열, 변수들
			int[] ySum = new int[100];
			int[] xSum = new int[100];
			int leftDiaSum = 0, rightDiaSum = 0; // 왼쪽 대각선, 오른쪽 대각선 합
			Posi leftDia = new Posi(0, 0); // 왼쪽 대각선, 오른쪽 대각선 판단할 포지션
			Posi rightDia = new Posi(0, 99);
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 행, 열 배열에 합
					ySum[i] += map[i][j];
					xSum[j] += map[i][j];
					// 대각선인지 체크
					if (i == leftDia.y && j == leftDia.x) {
						leftDiaSum += map[i][j];
						leftDia.y++; leftDia.x++;
					} 
					if (i == rightDia.y && j == rightDia.x) {
						rightDiaSum += map[i][j];
						rightDia.y++; rightDia.x++;
					}
				}
			}
			int xSumMax = 0, ySumMax = 0;
			for (int i = 0; i < 100; i++) {
				xSumMax = Math.max(xSumMax, xSum[i]);
				ySumMax = Math.max(ySumMax, ySum[i]);
			}
			int res = Math.max(xSumMax, Math.max(ySumMax, Math.max(leftDiaSum, rightDiaSum)));
			System.out.println("#" + tc + " "+ res);
		}
	}
	static class Posi {
		int y, x;
		public Posi(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
