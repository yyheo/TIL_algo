import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2636_치즈 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	private static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int size = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) size++;
			}
		}
		int time = 0;
		
		int preSize = 0;
		while(size != 0) {
			preSize = size;
			visited = new boolean[N][M];
			boolean flag = false;
			size = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0 && !visited[i][j] && !flag) {
						time++;
						go(i, j);
						flag = true;
					}
					if (map[i][j] == 1) {
						size++;
					}
					if (size != 0) preSize = size;
				}
			}
			// 녹인 치즈 구멍으로 만듬
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == -1) map[i][j] = 0;
				}
			}
		}
		System.out.println(time);
		System.out.println(preSize);
	}

	private static void go(int y, int x) {
		// 사방 치즈 녹이기
		melt(y, x);
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
			if (visited[ny][nx] || map[ny][nx] != 0) continue;
			go(ny, nx);
		} 
	}

	private static void melt(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
			if (map[ny][nx] == 1) map[ny][nx] = -1;
		}
	}
}
