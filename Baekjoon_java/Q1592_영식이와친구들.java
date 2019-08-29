import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1592_영식이와친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int cnt = 0;
		int idx = 0;
		while(!(++arr[idx] == M)) {
			cnt++;
			// 현재 받은 위치 홀수번이면 +L번째 (index N 초과시 다시 1로)
			if (arr[idx] % 2 == 1) {
				idx = (idx + L) % N;
			} else { // 짝수번이면 -L번째 (index 1 미만이면 N으로)
				idx -= (L % N);
				if (idx < 0) {
					idx = N + idx;
				}
			}
		}
		System.out.println(cnt);
	}
}
