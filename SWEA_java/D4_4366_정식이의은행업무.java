package tmpAlgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D4_4366_정식이의은행업무 {
	static int T;
	static char[] binary, triple;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String sys2 = br.readLine(); // 2진수
			String sys3 = br.readLine(); // 3진수
			long res = -1;
			String temp;
			for (int i = 0; i < sys2.length(); i++) {
				int digit2 = sys2.charAt(i) - '0';
				temp = sys2.substring(0, i) + (1 - digit2) + sys2.substring(i + 1);
				long bNum = Long.valueOf(temp, 2);
				for (int j = 0; j < sys3.length(); j++) {
					int digit3 = sys3.charAt(j) - '0';
					for (int k = 0; k < 3; k++) {
						if (digit3 == k)
							continue;
						temp = sys3.substring(0, j) + k + sys3.substring(j + 1);
						long tNum = Long.valueOf(temp, 3);
						if (bNum == tNum) {
							res = tNum;
							break;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + res);
		}
	}
}