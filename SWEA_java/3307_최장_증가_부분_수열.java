// DP

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T;

		T = scan.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			int N = scan.nextInt();
			int[] num = new int[N];
			int[] check = new int[N];
			int maxRes = 0;
			
			for (int i = 0; i < N; ++i) { // 수 입력
				num[i] = scan.nextInt();
			}
			
			check[0] = 1;
			for (int i = 1; i < N; ++i) {
				check[i] = 1;
				for (int j = 0; j < i; ++j) {
					if (num[i] > num[j] && check[j] + 1 > check[i]) {
						check[i] = check[j] + 1;
					}
				}
				if (check[i] > maxRes) maxRes = check[i];
			}
			
			System.out.println("#" + tc + " " + maxRes);
		}
	}
}
