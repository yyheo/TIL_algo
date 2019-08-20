import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1226_미로1 {
	
	static char map[][];
	static boolean visit[][];
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();	// 날림
			map = new char[16][16];
			visit = new boolean[16][16];
			for (int i = 0; i < 16; i++) {
				map[i] = br.readLine().toCharArray();
			}
			System.out.println("#" + tc + " " + go(1, 1));
		}
	}

	private static int go(int i, int j) {
		if (map[i][j] == '3') {
			return 1;
		}
		visit[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int ny = i + dy[k];
			int nx = j + dx[k];
			if (ny >= 16 || ny < 0 || nx >= 16 || nx < 0) continue;
			if (visit[ny][nx] == true
					|| map[ny][nx] == '1') continue;
			if (go(ny, nx) == 1) return 1;
		}
		return 0;
	}
}
