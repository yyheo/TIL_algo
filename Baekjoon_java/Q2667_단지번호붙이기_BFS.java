import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class WS1_단지번호붙이기_BFS_허윤영 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		ArrayList<Integer> res = new ArrayList<>();
		// BFS
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 단지 시작점 찾기
				if (map[i][j] == '0' || visited[i][j] == true) continue;
				int cnt = 0;
				Queue<Info> que = new LinkedList<Info>();
				visited[i][j] = true;
				que.add(new Info(i, j));
				cnt++;
				while(!que.isEmpty()) {
					Info cur = que.poll();
					for (int k = 0; k < 4; k++) {
						int ny = cur.y + dy[k];
						int nx = cur.x + dx[k];
						if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
						if (visited[ny][nx] || map[ny][nx] == '0') continue;
						que.add(new Info(ny, nx));
						visited[ny][nx] = true;
						cnt++;
					}
				}
				res.add(cnt);
			}
		}
		Collections.sort(res);
		System.out.println(res.size());
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
	static class Info {
		int y, x;
		public Info(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
