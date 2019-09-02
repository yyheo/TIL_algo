import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D4_1494_사랑의카운슬러_허윤영 {
	static int T, N;
	private static boolean[] visited;
	private static Info[] bug;
	private static long min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			bug = new Info[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				bug[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			min = Long.MAX_VALUE;
			visited = new boolean[N];
			matching(0, 0, 0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	private static void matching(int idx, int cnt, long sumX, long sumY) {
		if (idx >= N) {
			if (cnt == N/2) {
				if (sumX * sumX + sumY * sumY < min) {
					min = sumX * sumX + sumY * sumY;
				}
			}
			return;
		}
		
		matching(idx + 1, cnt + 1, sumX + bug[idx].x, sumY + bug[idx].y);
		matching(idx + 1, cnt, sumX - bug[idx].x, sumY - bug[idx].y);
	}

	private static boolean isMatching() {
		for (int i = 0; i < visited.length; i++) {
			if(visited[i] == false) return false;
		}
		return true;
	}

	public static class Info {
		int x, y;
		public Info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
