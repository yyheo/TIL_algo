
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 1; i <= T; ++i) {
			int tc = scan.nextInt();
			int[] arr = new int[101];
			for (int j = 0; j < 1000; j++) {
				int tmp = scan.nextInt();
				arr[tmp] += 1;
			}
			int res = 0, resIdx = 0;
			for (int j = 0; j < 101; j++) {
				if (res <= arr[j]) {
                    res = arr[j];
                    resIdx = j;
                }
			}
			
			System.out.println("#" + tc + " " + resIdx);
		}
	}
}
