package tmpAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3074_입국심사_허윤영 {
	static int T, N;
	static long M;
	private static long[] bar;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Long.parseLong(st.nextToken());
			bar = new long[N];
			long maxTime = 0;
			for (int i = 0; i < N; i++) {
				bar[i] = Long.parseLong(br.readLine());
				if(bar[i] > maxTime) maxTime = bar[i];
			}
			// 최소 ~ 최대 시간중에 가능한 시간 찾기
			long low = 1;
			long high = maxTime * M;
			long res = Long.MAX_VALUE;
			while(high > low) {
				long mid = (low + high) / 2;
				if (isPossible(mid)) {
					if(mid < res) res = mid;
					high = mid;
				} else {
					low = mid + 1;
				};
			}
			System.out.println("#" + tc + " " + res);
		}
	}
	
	private static boolean isPossible(long time) {
		long check = 0;
		for (int i = 0; i < N; i++) {
			// 해당 시간동안 각 bar가 사람을 얼마나 처리할 수 있는지 더함
			check += time / bar[i]; 
		}
		if (check >= M) return true;
		else return false;
	}
}