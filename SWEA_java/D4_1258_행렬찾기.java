import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기_허윤영 {
	
	static int T, n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int startY, startX, endY, endX;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// input
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ArrayList<Info> res = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					endY = -1; endX = -1;
					if (map[i][j] > 0 && !visited[i][j]) {
						startY = i; startX = j;
						go(i, j);
						//System.out.println(startY + " " + startX + " " + endY + " " + endX);
						// 행렬의 끝과 처음을 계산해서 크기를 계산함
						res.add(new Info(Math.abs(startY - endY) + 1, Math.abs(startX - endX) + 1, 
								(Math.abs(startY - endY) + 1) * (Math.abs(startX - endX) + 1)));
					}
				}
			}
			
			// 크기가 작은 순, 같으면 행이 작은 순으로 정렬
			Collections.sort(res, new Comparator<Info>() {
				@Override
				public int compare(Info o1, Info o2) {
					int res = o1.size - o2.size;
					if (res == 0) {
						res = o1.row - o2.row;
					}
					return res;
				}
			});
			
			// output
			System.out.print("#" + tc + " " + res.size() + " ");
			for (int i = 0; i < res.size(); i++) {
				System.out.print(res.get(i).row + " " + res.get(i).col + " ");
			}
			System.out.println();
		}
	}

	// dfs로 탐색
	private static void go(int y, int x) {
		if (y > endY || x > endX) {
			endY = y;
			endX = x;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= n || ny < 0 || nx >= n || nx < 0) continue;
			if (map[ny][nx] == 0 || visited[ny][nx]) continue;
			visited[ny][nx] = true;
			if (i < 2) {
				go(ny, nx);
			} else {
				go(ny, nx);
			}
		}
	}
	
	static class Info {
		int row, col, size;
		public Info(int row, int col, int size) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
		}
	}
}
