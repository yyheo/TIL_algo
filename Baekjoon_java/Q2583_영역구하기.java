import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2583_영역구하기 {
	
	static int M, N, K;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static POSI start, end;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			start = new POSI(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			end = new POSI(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			// 색칠된 사각형은 1로 표시
			for (int y = start.y; y < end.y; y++) {
				for (int x = start.x; x < end.x; x++) {
					map[y][x] = 1;
				}
			}
		}
		
		Queue<POSI> que = new LinkedList<POSI>();
		LinkedList<Integer> res = new LinkedList<>();
		
		int zon = 0;
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if(map[y][x] == 0) {
					zon += 1;
					int cnt = 0;
					que.add(new POSI(x, y));
					map[y][x] = 1;
					while(!que.isEmpty()) {
						POSI cur = que.poll();
						for (int i = 0; i < 4; i++) {
							int ny = cur.y + dy[i];
							int nx = cur.x + dx[i];
							if (ny >= M || ny < 0 || nx >= N || nx < 0) continue;
							if (map[ny][nx] == 1) continue;
							map[ny][nx] = 1;
							que.add(new POSI(nx, ny));
							cnt += 1;
						}
					}
					cnt += 1;
					res.add(cnt);
				}
			}
		}
		
		Collections.sort(res);
		System.out.println(zon);
		for (Integer integer : res) {
			System.out.printf(integer + " ");
		}
	}
	
	static class POSI {
		int y, x;
		public POSI(int x, int y) {
			this.y = y;
			this.x = x;
		}
	}
}
