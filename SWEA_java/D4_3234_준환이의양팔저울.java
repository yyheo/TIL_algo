import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_3234_준환이의양팔저울2 {
	static int T, N; // N : 무게 추의 수
	private static int[] w;
	private static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 1 <= N <= 9
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = new int[N];
			for (int i = 0; i < w.length; i++) {
				w[i] = Integer.parseInt(st.nextToken()); // 무게, 1 <= w <= 999
			}
			cnt = 0; // 가능한 가짓수
			perm(0, 0, 0);
			System.out.println("#" + tc + " " + cnt);
		}
	}

	// step  : 현재단계, l : 현재 단계까지 왼쪽 추들의 합, r : 오른쪽 추들의 합
	private static void perm(int step, int l, int r) {
		if (step == w.length) {
			cnt++;
			System.out.println(Arrays.toString(w));
		} else {
			for (int i = step; i < w.length; i++) {
				// 현재 step과 i swap
				int temp = w[step];
				w[step] = w[i];
				w[i] = temp;
				// 재귀호출
				perm(step + 1, l + w[step], r); // 저울의 왼쪽외 w[step]추를 올림
				if (l >= r + w[step]) {
					perm(step + 1, l, r + w[step]); // 저울의 오른쪽에 w[step]추를 올림
				}
				// 원상복구
				temp = w[step];
				w[step] = w[i];
				w[i] = temp;
			}
		}
	}
}