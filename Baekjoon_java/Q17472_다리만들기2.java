import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17472_다리만들기2 {
	static int T, N, M;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] parents;
	static int min;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
		st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// map에서 0이상이 나오면 (육지) 돌면서 사방에 비어있는 바다를 따라서 다리를 세움
		// 다른 섬과 연결 되면 연결된 섬을 돌면서 2로 바꿔줌
		// 재귀 돌면서 다리 갯수 보내주고, 다음 탐색하면서 1이 나오면 또 반복
		// 빠져나올 때 다리 철수하고 섬도 다시 돌려주기
		//setUp(0);
		// 다리의 폭은 1, 가로 혹은 세로로 갈 수 있음
		// 한 개의 다리는 두 개의 섬만 연결 가능. 직선으로만 가능
		// 다리는 섬의 선과 맞닿아야 함
		indexIsland();
		setUp(0);
		if (min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	private static int indexIsland() {
		int index = 0;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == false && map[i][j] == 1) {
					index++;
					fillIsland(new Posi(i, j), index);
				}
			}
		}
		return index;
	}
	
	private static void fillIsland(Posi target, int index) {
		Queue<Posi> que = new LinkedList<>();
		visited[target.y][target.x] = true;
		map[target.y][target.x] = index;
		que.add(target);
		while(!que.isEmpty()) {
			Posi cur = que.poll();
			for (int dir = 0; dir < 4; dir++) {
				int ny = cur.y + dy[dir];
				int nx = cur.x + dx[dir];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (map[ny][nx] == 0 || visited[ny][nx] == true) continue;
				map[ny][nx] = index;
				visited[ny][nx] = true;
				que.add(new Posi(ny, nx));
			}
		}
	}

	private static void setUp(int cnt) {
		if(allUnion()) { // 다리로 모두 연결 됐으면
			if(cnt < min) {
				min = cnt;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					for (int dir = 0; dir < 4; dir++) {
						int ny = i + dy[dir];
						int nx = j + dx[dir];
						if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						if (map[ny][nx] != 0) continue;
						int len = 1;
						while(true) {
							ny += dy[dir];
							nx += dx[dir];
							if (ny < 0 || ny >= N || nx < 0 || nx >= M) break;
							if (map[ny][nx] > 0) {
								if (map[ny][nx] != map[i][j] && len >= 2) {
									int tmp = map[ny][nx];
									check(new Posi(ny, nx), map[i][j]);
									setUp(cnt + len);
									check(new Posi(ny, nx), tmp);
								}
								break;
							}
							len++;
						}
					}
				}
			}
		}
	}
	
	private static boolean allUnion() {
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) continue;
				if (tmp == 0) {
					tmp = map[i][j];
				} else if (tmp != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void check(Posi target, int i) {
		Queue<Posi> que = new LinkedList<>();
		map[target.y][target.x] = i;
		que.add(target);
		while(!que.isEmpty()) {
			Posi cur = que.poll();
			for (int dir = 0; dir < 4; dir++) {
				int ny = cur.y + dy[dir];
				int nx = cur.x + dx[dir];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (map[ny][nx] == i || map[ny][nx] == 0) continue;
				map[ny][nx] = i;
				que.add(new Posi(ny, nx));
			}
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
