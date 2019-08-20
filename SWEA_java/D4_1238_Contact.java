import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1238_Contact {
	static int len, start;
	static int[][] map;
	static boolean[] visit;
	static int last, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			// input
			map = new int[101][101];
			visit = new boolean[101];
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			last = max = 0;
			for (int i = 0; i < len / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = 1;
			}
			
			// DFS (재귀)로 했을 경우 더 짧은 경로가 있어도 먼저 나온 경로를 따라가게 되므로 BFS로 해야함 ..
			Queue<Posi> que = new LinkedList<>();
			visit[start] = true;
			que.offer(new Posi(start, 1));
			
			while(!que.isEmpty()) {
				Posi cur = que.poll();
				if (cur.step > last) {
					last = cur.step;
					max = cur.no;
				} else if (cur.step == last && max < cur.no) {
					max = cur.no;
				}
				for (int j = 1; j <= 100; j++) {
					if (map[cur.no][j] == 1 && !visit[j]) {
						//System.out.println(cur.no + " " + j + " " + cur.step);
						visit[j] = true;
						que.add(new Posi(j, cur.step + 1));
					}
				}
			}

			System.out.println("#" + tc + " " + max);
		}
	}
	static class Posi {
		int no, step;
		public Posi(int no, int step) {
			super();
			this.no = no;
			this.step = step;
		}
	}
}
