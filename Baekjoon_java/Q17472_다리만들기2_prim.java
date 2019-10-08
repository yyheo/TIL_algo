import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// prim 사용한 방법

public class Q17472_다리만들기2_prim {
	static int T, N, M, index, result;
	static int[][] weight;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		} // end input
		
		// 섬마다 index로 채워주기 (BFS 사용)
		indexIsland();
		weight = new int[index + 1][index + 1];
		
		// 모든 섬에서 다리를 세워주면서 weight 체크
		checkWeight();
/*		for (int i = 0; i <= index; i++) {
			System.out.println(Arrays.toString(weight[i]));
		}*/
		
		// prim 알고리즘으로 mst 만들기
		int res = prim() == true ? result : -1;
		System.out.println(res);
	}
	
	private static boolean prim() {
		int count = 0;
		PriorityQueue<Vertex> que = new PriorityQueue<Vertex>();
		boolean[] visitPrim = new boolean[index + 1];
		// 임의의 정점(0)을 첫 정점으로 선택
		que.offer(new Vertex(1, 0));
		result = 0;
		
		while (!que.isEmpty()) {
			Vertex current = que.poll();
			if (visitPrim[current.vertex]) continue; // 현정점이 이미 처리된 정점이면 다음 poll
			result += current.weight;
			visitPrim[current.vertex] = true;
			if(++count == index) break;
			for (int i = 1; i <= index; i++) {
				if(!visitPrim[i] && weight[current.vertex][i] != 0) {
					que.offer(new Vertex(i, weight[current.vertex][i]));
				}
			}
		}
		for (int i = 1; i < visitPrim.length; i++) {
			if(visitPrim[i] == false) return false;
		}
		return true;
	}

	private static void checkWeight() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > 0) { // 섬이 나오면 상하좌우를 봄
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
								if(len >= 2 && map[ny][nx] != map[i][j] &&
										(weight[map[i][j]][map[ny][nx]] > len ||
										weight[map[i][j]][map[ny][nx]] == 0)) {
									weight[map[i][j]][map[ny][nx]] = weight[map[ny][nx]][map[i][j]] = len;
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

	private static void indexIsland() {
		index = 0;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == false && map[i][j] == 1) {
					index++;
					fillIsland(new Posi(i, j), index);
				}
			}
		}
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
	
	static class Vertex implements Comparable<Vertex>{
		int vertex;
		int weight;
		public Vertex(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
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
