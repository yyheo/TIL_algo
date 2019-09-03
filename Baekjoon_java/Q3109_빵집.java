import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3109_빵집 {
	private static char[][] map;
	static int[] dy = { -1, 0, +1}; // 0: 오른쪽 위 대각선, 1: 오른쪽, 2: 오른쪽 아래 대각선
	static int[] dx = { 1, 1, 1 };
	static int R, C;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			setPipe(i, 0);
		}
		System.out.println(max);
	}
	
	private static boolean setPipe(int y, int x) {
		if (x == C - 1) {
			map[y][x] = 'V';
			max++;
			return true;
		}
		boolean flag = false;
		for (int dir = 0; dir < 3; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
			if (map[ny][nx] != '.') continue;
			map[y][x] = (char)(dir + '0');
			flag = setPipe(ny, nx);
			if(flag) return true;
		}
		return false;
	}
}
