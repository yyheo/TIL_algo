import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16973_직사각형탈출 {
	static int N, M, H, W;
	static Posi start, end;
	private static int[][] map;
	private static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		start = new Posi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		end = new Posi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		
		// BFS
		Queue<Posi> que = new LinkedList<>();
		visited[start.y][start.x] = true;
		que.add(start);
		Posi cur = null;
		int min = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			cur = que.poll();
			if (cur.y == end.y && cur.x == end.x) {
				if (cur.cnt < min) {
					min = cur.cnt;
				}
				break;
			}
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if(ny < 1 || ny >= N+1 || nx < 1 || nx >= M+1) continue;
				if(ny + H - 1 >= N+1 || nx + W - 1 >= M+1) continue;
				if(!isPossible(ny, nx, i)) continue;
				if(visited[ny][nx]) continue;
				visited[ny][nx] = true;
				que.add(new Posi(ny, nx, cur.cnt + 1));
			}
			//if (cur!=null) System.out.println(cur.y + " " + cur.x + " " + cur.cnt);
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : cur.cnt);
	}
	
	// 커지는 변 하나만 1이 있는지 체크해줌. 전부 체크했더니 시간초과..
	private static boolean isPossible(int ny, int nx, int dir) {
		if (dir == 0) { // 상
			for (int i = nx; i < nx + W; i++) {
				if (map[ny][i] == 1) return false;
			}
		} else if (dir == 1) { // 하
			for (int i = nx; i < nx + W; i++) {
				if (map[ny + H - 1][i] == 1) return false;
			}
		} else if (dir == 2) { // 좌
			for (int i = ny; i < ny + H; i++) {
				if (map[i][nx] == 1) return false;
			}
		} else if (dir == 3) { // 우
			for (int i = ny; i < ny + H; i++) {
				if (map[i][nx + W - 1] == 1) return false;
			}
		} 
		return true;
	}
	static class Posi {
		int y, x, cnt;
		public Posi(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
