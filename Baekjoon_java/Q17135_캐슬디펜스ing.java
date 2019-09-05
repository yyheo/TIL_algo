import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17135_캐슬디펜스ing {
	static int N, M, D;
	static int[][] map, origin;
	static boolean[][] visited;
	static int[] hunter = new int[3];
	static int[] dy = { -1, 0, 0 };
	static int[] dx = { 0, -1, 1 };
	static int max;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		origin = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 궁수 3명 배치
		combi(0, -1);
		System.out.println(max);
	}
	
	static void combi(int idx, int pre) {
		if(idx == 3) {
			// System.out.println(Arrays.toString(hunter));
			game();
			return;
		}
		for (int i = pre + 1; i < 5; i++) {
			hunter[idx] = i;
			combi(idx + 1, i);
		}
	}

	private static void game() {
		map = new int[N+1][M];
		// 게임을 진행할 map 복사
		for (int i = 0; i < N; i++) {
			map[i] = origin[i].clone();
		}
		
		int cnt = 0;
		// 게임은 행만큼만 진행함 (N번 후엔 무조건 게임 끝)
		while(!mapEmpty()) {
			// 한 게임마다 사냥꾼 하나씩 봄
			HashSet<String> targetSet = new HashSet<>();
			Posi[] targets = new Posi[3];
			for (int i = 0; i < hunter.length; i++) {
				visited = new boolean[N][M];
				Queue<Posi> que = new LinkedList<>();
				que.add(new Posi(N, hunter[i], 0));
				Posi target = null;
				while(!que.isEmpty()) {
					Posi cur = que.poll();
					// 큐에서 이번에 뽑은게 타겟이면
					if (map[cur.y][cur.x] == 1 && cur.dis <= D) {
						if (target != null &&
								cur.dis > target.dis) break;
						if (target == null) target = cur;
						else if (cur.dis < target.dis ||
								(cur.dis == target.dis && cur.x < target.x)) {
							target = cur;
						}
					}
					for (int dir = 0; dir < 3; dir++) {
						int ny = cur.y + dy[dir];
						int nx = cur.x + dx[dir];
						if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						if (visited[ny][nx] == true) continue;
						visited[ny][nx] = true;
						que.add(new Posi(ny, nx,
								Math.abs(N - ny) + Math.abs(hunter[i] - nx)));
					}
				}
				if (target != null) {
					targets[i] = target;
					//targetSet.add(target.y + " " + target.x);
				}
			}
			for (int i = 0; i < targets.length; i++) {
				if (targets[i] != null && map[targets[i].y][targets[i].x] == 1) {
					map[targets[i].y][targets[i].x] = 0;
					cnt++;
				}
			}
			
			
/*			for (String s : targetSet) {
				st = new StringTokenizer(s);
				cnt++;
				int tmpy = Integer.parseInt(st.nextToken());
				int tmpx = Integer.parseInt(st.nextToken());
				map[tmpy][tmpx] = 0;
				//System.out.println(tmpy + " " + tmpx);
			}*/
			down();
			//System.out.println();
		}
		if (max < cnt) {
			max = cnt;
		}
		//System.out.println("-----------------------------");
	}

	private static boolean mapEmpty() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) return false;
			}
		}
		return true;
	}

	private static void down() {
		// 배열 아래로 당겨주고
		for (int i = N - 1; i > 0; i--) {
			map[i] = map[i - 1].clone();
		}
		// 제일 위는 0으로 채움
		for (int i = 0; i < M; i++) {
			map[0][i] = 0;
		}
	}

	static class Posi {
		int y, x, dis;
		public Posi(int y, int x, int dis) {
			super();
			this.y = y;
			this.x = x;
			this.dis = dis;
		}
	}
}
