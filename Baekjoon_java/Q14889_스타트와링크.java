import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14889_스타트와링크 {
	private static int N;
	private static int[][] S;
	private static int[] C;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 스타트와 링크 팀으로 사람을 나눠야 함
		// 팀의 능력치는 팀에 속한 모든 쌍의 능력치의 합
		// 단방향 그래프
		// 전체 사람 N에서 N/2 조합 구하깅

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		C = new int[N / 2];
		// 스타트 팀에 들어가는 조합을 구함
		combi(0, -1);
		System.out.println(min);
	}

	private static void combi(int cnt, int pre) {
		if (cnt >= N / 2) {
			//System.out.println(Arrays.toString(C));
			checkMin();
			return;
		}
		for (int i = pre + 1; i < N; i++) {
			C[cnt] = i;
			combi(cnt + 1, i);
		}
	}

	private static void checkMin() {
		int start = 0;
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N / 2 - 1; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				start += S[C[i]][C[j]];
				start += S[C[j]][C[i]];
				visited[C[j]] = true;
			}
			visited[C[i]] = true;
		}

		int link = 0;
		for (int i = 0; i < N; i++) {
			if (visited[i] == true)
				continue;
			for (int j = 0; j < N; j++) {
				if (visited[j] == true)
					continue;
				link += S[i][j];
			}
		}
		//System.out.println(start + " " + link);
		if (Math.abs(start - link) < min) {
			min = Math.abs(start - link);
		}
	}
}
