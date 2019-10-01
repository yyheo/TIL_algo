package tmpAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_4301_콩많이심기 {
	static int T, N, M, cnt, max;
	static boolean[][] map;
	static int[] dy = { -2, 2, 0, 0};
	static int[] dx = { 0, 0, -2, 2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = true;
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == true) {
						cnt++;
						for (int dir = 0; dir < 4; dir++) {
							int ny = i + dy[dir];
							int nx = j + dx[dir];
							if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
							map[ny][nx] = false;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
