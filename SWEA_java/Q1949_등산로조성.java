import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1949_등산로조성 {
	static int N, K; // map 길이 N, 최대 공사 가능 깊이 K
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			max = 0;
			int highnum = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > highnum) highnum = map[i][j];
				}
			}
			// 가장 높은 봉우리 찾기
			ArrayList<Posi> high = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == highnum) high.add(new Posi(i, j));
				}
			}
			
			// map에서 하나씩, 최대 공사 가능 깊이 1씩 깎음 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int origin = map[i][j]; // 원래 높이
					int depth = 0;
					while(++depth <= K) {
						map[i][j] = origin - depth; // 지형 깎아서 공사
						// 가장 높은 봉우리에서부터 공사 (만약 위에서 깎인 봉우리랑 동일하면 pass)
						for (int idx = 0; idx < high.size(); idx++) {
							visited = new boolean[N][N];
							go(high.get(idx).y, high.get(idx).x, 1);
						}
						map[i][j] = origin; // 복구
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
	
	// 낮은 곳으로 사방 이동하면서 길이 계산
	private static void go(int y, int x, int cnt) {
		visited[y][x] = true;
		if (cnt > max) {
			max = cnt;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
			if (map[ny][nx] >= map[y][x]) continue;
			go(ny, nx, cnt + 1);
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
