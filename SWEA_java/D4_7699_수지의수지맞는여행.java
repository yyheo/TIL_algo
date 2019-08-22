import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_7699_수지의수지맞는여행 {
	
	static int T, R, C, max;
	static char[][] map;
	static boolean[] see;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			max = 0;
			map = new char[R][C];
			see = new boolean[26];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			see[map[0][0] - 'A'] = true; 
			go(0, 0, 1);
			sb.append('#').append(tc).append(' ').append(max).append('\n');
			//System.out.println("#" + tc + " " + max);
		}
		System.out.print(sb);
	}

	// dfs
	// 1행 1열부터 시작 (사실은 0행 0열임)
	// 반복문 : 같은 구조이면 재귀함수보다 더 빠르다
	// 재귀함수 : 깊이우선, 너비우선 등, 가지치기들을 자유롭게 할 수 있다는 장점
	// 백트래킹의 포커스는 가지치기 !!
	private static void go(int y, int x, int cnt) {
		if (max == 26) return; // 최대로 가질 수 있는 max값이 26이기 때문에 26이 나오면 더 보지 않아도 됨
		if (cnt >= max) { // 최대값 리턴
			max = cnt;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i]; // 풀어쓰면 더 빠름...
			int nx = x + dx[i];
			if (ny >= R || ny < 0 || nx >= C || nx < 0) continue;
			// 본 알파벳 명물이면 탐색하지 않음, visit 체크
			if (see[map[ny][nx] - 'A'] == true) continue; 
			see[map[ny][nx] - 'A'] = true;
			go(ny, nx, cnt + 1); // 본 명물의 개수 체크
			see[map[ny][nx] - 'A'] = false;
		}
	}
}
