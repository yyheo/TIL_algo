package tmpAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2636_치즈2 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	public static void main(String[] args) throws NumberFormatException, IOException {
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
				if (map[i][j] == 1) size++;
			}
		}
		// 치즈가 구멍인지 아닌지 flag.
		// (맨처음 한번 공기가 나오고 dfs 돌린후에 나오는 공기는 구멍임)
		int res = size;
		int time = 0;
		while (size > 0) {
			visited = new boolean[N][M];
			boolean flag = false;
			size = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0 && visited[i][j] == false && !flag) {
						go(i, j);
						flag = true;
						time++;
					}
					if (map[i][j] == 1) {
						size++;
					}
				}
			}
			// 다 녹지 않았을 경우만 답 갱신
			if (size > 0) res = size;
			// 녹인 치즈 공기로 만듬
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					if(map[i][j] == -1) {
						map[i][j] = 0;
					}
				}
			}
		}
		System.out.println(time);
		System.out.println(res);
	}
	private static void go(int i, int j) {
		visited[i][j] = true;
		// 사방 녹이기
		melt(i, j);
		for (int dir = 0; dir < 4; dir++) {
			int ny = i + dy[dir];
			int nx = j + dx[dir];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
			if (visited[ny][nx] == true || map[ny][nx] != 0) continue;
			go(ny, nx);
		}
	}
	
	private static void melt(int i, int j) {
		for (int dir = 0; dir < 4; dir++) {
			int ny = i + dy[dir];
			int nx = j + dx[dir];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
			if (map[ny][nx] == 1) map[ny][nx] = -1;
		}
	}
}
