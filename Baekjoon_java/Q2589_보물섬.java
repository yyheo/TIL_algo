import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2589_보물섬 {
	static char[][] map;
	static boolean[][] visited;
	static int N, M;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'L') { // 가장 먼 곳 찾기
					// BFS
					visited = new boolean[N][M];
					Queue<Posi> que = new LinkedList<Posi>();
					que.add(new Posi(i, j, 0));
					visited[i][j] = true;
					Posi cur = null;
					while(!que.isEmpty()) {
						cur = que.poll();
						for (int dir = 0; dir < 4; dir++) {
							int ny = cur.y + dy[dir];
							int nx = cur.x + dx[dir];
							if (ny >= N || ny < 0 || nx >= M || nx < 0) continue;
							if (visited[ny][nx] || map[ny][nx] != 'L') continue;
							que.add(new Posi(ny, nx, cur.dis + 1));
							visited[ny][nx] = true;
						}
						// System.out.println(cur.y + " " + cur.x + " " + cur.dis);
					}
					if (cur.dis > max) {
						max = cur.dis;
					}
				}
			}
		}
		System.out.println(max);
	}
	static class Posi {
		int y, x, dis;
		public Posi(int y, int x, int dis) {
			super();
			this.y = y;
			this.x = x;
			this.dis = dis;
		}
	}
}
