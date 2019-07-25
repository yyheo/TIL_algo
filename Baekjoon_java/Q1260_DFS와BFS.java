package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260_DFS와BFS {
	
	static int N, M, V;
	static int[][] graph;
	static int[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][N + 1];
		
		int a, b;
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		
		visit = new int[N + 1];
		visit[V] = 1;
		DFS(V);
		System.out.println();
		visit = new int[N + 1]; // visit 함수 초기화
		BFS(V);
	}
	
	static void DFS(int start) {
		System.out.print(start + " ");
		for (int i = 1; i <= N; i++) {
			if (graph[start][i] == 1 && visit[i] == 0) { // 그래프가 이어져있고, 방문하지 않았으면
				visit[i] = 1;
				DFS(i);
			}
		}
	}
	
	static void BFS(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		visit[start] = 1;
		que.add(start);
		while (!que.isEmpty()) {
			int front = que.remove();
			System.out.print(front + " ");
			
			for (int i = 1; i <= N; i++) {
				if (graph[front][i] == 1 && visit[i] == 0) { // 그래프가 이어져있고, 방문하지 않았으면
					visit[i] = 1;
					que.add(i);
				}
			}
		}
	}
}
