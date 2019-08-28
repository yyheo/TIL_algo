import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1037_오류교정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[] row = new int[N];
		int[] col = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 각각 행, 열 1 갯수 셈
				row[i] += map[i][j];
				col[j] += map[i][j];
			}
		}
		int check = 0;
		int changeR = -1, changeC = -1;
		// 홀수인게 행, 열 각각 짝이 맞으면 change bit 가능
		// 안맞으면 Corrupt
		for (int i = 0; i < N; i++) {
			if (row[i] % 2 != 0) {
				check++;
				changeR = i + 1;
			}
			if (col[i] % 2 != 0) {
				check--;
				changeC = i + 1;
			}
		}
		if (check != 0) {
			System.out.println("Corrupt");
		} else if (changeR == -1 && changeC == -1){
			System.out.println("OK");
		} else {
			System.out.printf("Change bit (%d,%d)\n", changeR, changeC);
		}
	}
}
