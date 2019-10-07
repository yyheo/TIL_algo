package tmpAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D4_1249_보급로 {
	static int T, N, min;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dist;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			dist = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			Queue<Posi> que = new LinkedList<>();
			visited[0][0] = true;
			dist[0][0] = 0;
			que.add(new Posi(0, 0));
			while(!que.isEmpty()) {
				Posi cur = que.poll();
				for (int dir = 0; dir < 4; dir++) {
					int ny = cur.y + dy[dir];
					int nx = cur.x + dx[dir];
					if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
					if (!visited[ny][nx] ||
							dist[cur.y][cur.x] + (int)(map[ny][nx] - '0') < dist[ny][nx]) {
						visited[ny][nx] = true;
						dist[ny][nx] = dist[cur.y][cur.x] + (int)(map[ny][nx] - '0');
						que.add(new Posi(ny, nx));
					}
				}
			}
			System.out.println("#" + tc + " " + dist[N - 1][N - 1]);
		}
	}
	static class Posi {
		int y, x;
		public Posi(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
