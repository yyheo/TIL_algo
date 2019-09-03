import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17406_배열돌리기4 {
	private static int M;
	private static int K;
	private static int N, min = Integer.MAX_VALUE;
	private static int[][] map, origin;
	private static Info[] oper;
	static int[] dy = { 0, +1, 0, -1};
	static int[] dx = { +1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());		
		origin = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		oper = new Info[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			oper[i] = new Info(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 연산 순열
		permu(0);
		System.out.println(min);
	}
	
	private static void permu(int idx) {
		if (idx >= K) {
			// System.out.println(Arrays.toString(oper));
			// 순열 완료시 회전
			rotate();
			// 최소값 구함
			checkMin();
			return;
		}
		for (int i = idx; i < K; i++) {
			// swap
			Info tmp = oper[idx];
			oper[idx] = oper[i];
			oper[i] = tmp;
			permu(idx + 1);
			// 원상복구
			tmp = oper[idx];
			oper[idx] = oper[i];
			oper[i] = tmp;
		}
	}

	private static void checkMin() {
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += map[i][j];
				if (sum >= min) break;
			}
			if (sum < min) {
				min = sum;
			}
		}
	}

	private static void rotate() {
		// 원본 배열을 복사
		map = new int[N][M];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				map[y][x] = origin[y][x];
			}
		}
		
		for (int i = 0; i < K; i++) {
			Info cur = oper[i];
			// 임시 배열 복사
			int[][] tmp = new int[N][M];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					tmp[y][x] = map[y][x];
				}
			}
			
			int startY = cur.r - cur.s - 1;
			int startX = cur.c - cur.s - 1;
			int endY = cur.r + cur.s - 1;
			int endX = cur.c + cur.s - 1;
			int num = (endY - startY + 1) / 2;
			for (int k = 0; k < num; k++) { // 돌려야 하는 사각형 갯수
				int y = startY; int x = startX;
				do {
					// 방향 전환
					for (int dir = 0; dir < 4; dir++) {
						while(true) {
 							int ny = y + dy[dir];
 							int nx = x + dx[dir];
    						if (ny > endY || ny < startY || nx > endX || nx < startX) break;
 							tmp[ny][nx] = map[y][x];
							y = ny;
 							x = nx;
 						}
					}
				} while (!(y == startY && x == startX));
				startX++; startY++;
				endX--; endY--;
			}
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					map[y][x] = tmp[y][x];
				}
			}
		}
	}

	static class Info {
		int r, c, s;
		public Info(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
