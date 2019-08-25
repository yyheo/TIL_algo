import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1230_선물의집 {
	static int[][] map, visit;
	static int max, n;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit[0][0] = 1;
		go(0, 0, 0);
		System.out.println(max);
	}
	private static void go(int y, int x, int sum) {
		if (map[y][x] == 2) sum += 1;
		if (sum >= n * n) return;
		if (y == n - 1 && x == n - 1) {
			if (sum >= max) max = sum;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= n || ny < 0 || nx >= n || nx < 0) continue;
			if (map[ny][nx] == 1 || visit[ny][nx] == 1) continue;
			visit[ny][nx] = 1;
			go(ny, nx, sum);
			visit[ny][nx] = 0;
		}
	}
}
