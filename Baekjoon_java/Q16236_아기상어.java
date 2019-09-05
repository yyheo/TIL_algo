import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16236_아기상어 {
	static Shark shark;
	static int N;
	static int eat;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 0, +1, 0 }; // 상 좌 하 우
	static int[] dx = { 0, -1, 0, +1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		}
		Shark target;
		do {
			target = null;
			visited = new boolean[N][N];
			Queue<Shark> que = new LinkedList<>();
			visited[shark.y][shark.x] = true;
			que.add(shark);
			// 아기상어 1초에 한칸씩 이동
			while(!que.isEmpty()) {
				Shark cur = que.poll();
				// 큐에 들어있는 물고기들이 거리가 늘어나는 순간 그만 찾음
				if (target != null && cur.time > target.time) break;
				// 같은 시간에 도착한다면 가장 위, 가장 왼쪽에 있는 물고기로
				if (target == null || 
						(cur.y < target.y || (cur.y == target.y && cur.x < target.x))) {
					target = cur;
				}
				}
				for (int dir = 0; dir < 4; dir++) { 
					int ny = cur.y + dy[dir];
					int nx = cur.x + dx[dir];
					if (ny < 0 || ny >= N || nx < 0 || nx >= N
							|| visited[ny][nx]) continue;
					// 큰 물고기 칸은 못지나감. 작거나 같은 물고기만 큐에 넣어줌
					if (map[ny][nx] > shark.size) continue;
					visited[ny][nx] = true;
					que.add(new Shark(ny, nx, map[ny][nx], cur.time + 1));
				}
			}
			// 찾았으면 먹음. 그 자리 0으로 갱신
			if (target != null) {
				eat++;
				map[target.y][target.x] = 0;
				shark = new Shark(target.y, target.x, shark.size, target.time);
				//System.out.println(target.y + " " + target.x);
			}
			// 먹었는데 상어 크기와 똑같으면 상어 크기 증가시키기
			if (eat == shark.size) {
				shark.size++;
				eat = 0;
			}
		} while (target != null);
		System.out.println(shark.time);
	}
	
	static class Shark {
		int y, x, size, time;
		public Shark(int y, int x, int size, int time) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
			this.time = time;
		}
	}
}
