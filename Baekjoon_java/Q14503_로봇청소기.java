import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14503_로봇청소기 {
	static int cnt;
	static int N, M, r, c, d;
	static int[][] map, visited;
	static int[] dy = { -1, 0, 1, 0 }; // 북 동 남 서
	static int[] dx = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go(r, c, d);
		System.out.println(cnt);
	}

	// 청소기 y, x, dir
	private static boolean go(int y, int x, int dir) {
		// 로봇청소기 현재 위치 청소
		if(map[y][x] == 0) cnt++;
		visited[y][x] = 1;
		map[y][x] = 2;
		// 청소하지 않은 공간 존재시 회전 후 한칸 전진, 반복
		// 존재하지 않으면 회전 후 또 탐색 반복
		for (int i = 1; i < 5; i++) {
			// 현재 방향 기준으로 왼쪽부터 탐색
			int next = dir - i < 0 ? 4 + dir - i : dir - i;
			int ny = y + dy[next];
			int nx = x + dx[next];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
			if (visited[ny][nx] == 1 || map[ny][nx] == 1) continue;
			if (!go(ny, nx, next)) return false;
		}
		// 네 곳 다 청소 되었거나 벽일 경우, 방향 유지한다음 후진
		int backdir = 0;
		if (dir == 2 || dir == 3) backdir = dir - 2;
		else backdir = dir + 2;
		int ny = y + dy[backdir];
		int nx = x + dx[backdir];
		// 후진도 못할 경우엔 작동 중단
		if (ny < 0 || ny >= N || nx < 0 || nx >= M) return false;
		if (map[ny][nx] == 1) return false;
		return go(ny, nx, dir);
	}
}
