package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2667_단지번호붙이기 {
	static int N, cnt;
	static int[] count = new int[626];
	static int[][] map, visit;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		// DFS
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visit[i][j] == 0) {
					DFS(i, j);
					cnt += 1;
				}
			}
		}
		
		// output
		System.out.println(cnt);
		Arrays.sort(count, 0, cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.println(count[i]);
		}
	}
	
	static void DFS(int y, int x) {
		visit[y][x] = 1;
		count[cnt] += 1;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= N || ny < 0 || nx >= N || nx < 0) continue;
			if (visit[ny][nx] == 1 || map[ny][nx] == 0) continue;
			DFS(ny, nx);
		}
	}
}
