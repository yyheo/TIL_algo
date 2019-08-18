import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class D3_1206_View {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			int len, res = 0;
			len = Integer.parseInt(br.readLine());
			// map input
			int[] map = new int[len];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 2; i < len - 2; i++) {
				// 좌우 2개 구역 중 최대 건물 길이를 비교
				int max = Math.max(map[i - 2], Math.max(map[i - 1], Math.max(map[i + 1], map[i + 2])));
				max = map[i] - max < 0 ? 0 : map[i] - max;
				res += max;
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
