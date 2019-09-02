import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2303_숫자게임 {
	private static int[][] cards;
	private static int max, res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cards = new int[N][5];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				cards[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		max = 0;
		for (int i = 0; i < N; i++) {
			combi(i, 0, 0, 0);
		}
		
		// output
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
	}

	private static void combi(int people, int idx, int cnt, int sum) {
		if (cnt >= 3) {
			if (sum % 10 >= max) {
				max = sum % 10;
				res = people + 1;
			}
			return;
		}
		if (idx >= 5) {
			return;
		}
		combi(people, idx + 1, cnt + 1, sum + cards[people][idx]); // 현재꺼 선택 O
		combi(people, idx + 1, cnt, sum); // 현재꺼 선택 X
	}
}
