import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_6179_성수의프로그래밍강좌시청 {
	static int T, N, K;
	static double A;
	static Integer[] num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			num = new Integer[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				//System.out.println((int)1/Math.pow(2, num[i]));
			}
			//System.out.println(Arrays.toString(num));
			Arrays.sort(num);
			//System.out.println(Arrays.toString(num));
			A = 0;	// 성수의 초기 실력
			double mul = 2;
			for (int i = N-1; i >= N-K; i--) {
				A += num[i] / mul;
				
				mul *= 2;
			}
			System.out.printf("#%d %.6f\n", tc, A);
		}
	}
}
