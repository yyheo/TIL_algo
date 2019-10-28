import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_5672_올해의조련사_허윤영 {
	static int T, N;
	private static Character[] oldLine;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			oldLine = new Character[N];
			for (int i = 0; i < N; i++) {
				oldLine[i] = br.readLine().toCharArray()[0];
			}
			StringBuilder sb = new StringBuilder();
			int start = 0;
			int end = N-1;
			while(start < end) {
				if (oldLine[start] < oldLine[end]) {
					// start가 end보다 작으면 무조건 start 넣고
					sb.append(oldLine[start++]);
				} else if (oldLine[start] > oldLine[end]) {
					// end가 작으면 무조건 end 넣고
					sb.append(oldLine[end--]);
				} else {
					// 같으면
					int inStart = start;
					int inEnd = end;
					while(true) {
						if(oldLine[inStart] < oldLine[inEnd]) {
							sb.append(oldLine[start++]);
							break;
						} else if(oldLine[inStart] > oldLine[inEnd]) {
							sb.append(oldLine[end--]);
							break;
						}
						if(inStart >= inEnd) {
							sb.append(oldLine[start++]);
							break;
						}
						inStart++;
						inEnd--;
					}
				}
			}
			sb.append(oldLine[start]);
			System.out.println("#" + tc + " " + sb);
		}
	}
}
