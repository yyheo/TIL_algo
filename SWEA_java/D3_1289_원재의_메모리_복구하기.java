import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T;

		T = scan.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			int res = 0;
			String cur;
			cur = scan.next();
			char curCh = '0';
			for (int i=0; i<cur.length(); i++) {
				if (cur.charAt(i) != curCh) {
					res += 1;
					curCh = cur.charAt(i);
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
