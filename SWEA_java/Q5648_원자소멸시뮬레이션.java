import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mock_5648_원자소멸시뮬레이션 {
	static int size = 4001;
	static int N, K, sum;
	static int[][] map = new int[size][size];
	static int[] dy = { 1, -1, 0, 0 }; // xy좌표를 받아오기 위해 map 뒤집어줬기 때문에 방향도 반대
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			Info[] oneso = new Info[N + 1];
			Queue<Info> que = new LinkedList<>();
			sum = 0;
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) * 2;
				int y = Integer.parseInt(st.nextToken()) * 2;
				int dir = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				oneso[i] = new Info(i, x + 2000, y + 2000, dir, e);
				map[oneso[i].y][oneso[i].x] = oneso[i].e;
				que.add(oneso[i]);
			}
			
			while(!que.isEmpty()) {
				Info cur = que.poll();
				// 내가 이동한 이후 누군가 나한테 부딪혔을 경우
				if (map[cur.y][cur.x] > cur.e) { 
					sum += map[cur.y][cur.x];
					map[cur.y][cur.x] = 0;
					continue;
				}
				int ny = cur.y + dy[cur.dir];
				int nx = cur.x + dx[cur.dir];
				// map 크기 벗어나면 원소 죽임
				if (ny < 0 || ny >= size || nx < 0 || nx >= size) {
					map[cur.y][cur.x] = 0;
					continue;
				}
				// 원소 충돌시 둘 다 죽이고 에너지 분출
				if (map[ny][nx] > 0) {
					map[ny][nx] += cur.e;
					map[cur.y][cur.x] = 0;
					continue;
				}
				// 그냥 이동 가능. 아무것도 없으면
				map[cur.y][cur.x] = 0;
				map[ny][nx] = cur.e;
				que.add(new Info(cur.index, nx, ny, cur.dir, cur.e));
			}
			
			System.out.println("#" + tc + " " + sum);
			
		}
	}
	
	static class Info {
		int index, y, x, dir, e;
		public Info(int index, int x, int y, int dir, int e) {
			super();
			this.index = index;
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.e = e;
		}
	}
}
