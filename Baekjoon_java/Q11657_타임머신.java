package tmp;

import java.awt.Component.BaselineResizeBehavior;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 벨만-포드 Bellman-Ford

public class Q11657_타임머신 {
	private final static int INF = 9999999;
	private static int count;
	private static int edgeCount;
	private static int[] distance;
	static Edge[] edges;
	static class Edge {
		int from, to, time;
		public Edge(int from, int to, int time) {
			super();
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		count = Integer.parseInt(st.nextToken()); // 정점 갯수 (도시)
		edgeCount = Integer.parseInt(st.nextToken()); // 간선 갯수 (버스)
		distance = new int[count]; // 1번도시에서 각 도시로 오는 최소시간
		edges = new Edge[edgeCount];
		Arrays.fill(distance, INF);
		for (int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			edges[i] = new Edge(Integer.parseInt(st.nextToken()) - 1
					, Integer.parseInt(st.nextToken()) - 1
					, Integer.parseInt(st.nextToken()));
		}
		distance[0] = 0; // 시작점 비용은 0으로
		if(goNegativeCycle()) { // 음수 싸이클 발견
			System.out.println(-1);
		} else {
			for (int i = 1; i < count; i++) {
				System.out.println(distance[i] == INF? -1 : distance[i]);
			}
		}
	}

	private static boolean goNegativeCycle() {
		for (int i = 1; i <= count; i++) {
			for (Edge e : edges) { // from => to로 가는 비용
				if(distance[e.from] == INF) continue; // INF면 밑에 식을 아무리 계산을 해도 갱신이 안되기 때문에
				if(distance[e.from] + e.time < distance[e.to]) {
					distance[e.to] = distance[e.from] + e.time;
					if(i == count) {
						// 최소시간이 업데이트 된 경우의 라운드 수가 정점카운트와 동일하다면 음수 싸이클 존재
						return true;
					}
				}
			}
		}
		return false;
	}
}
