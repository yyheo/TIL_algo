package com.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576_토마토 {
	
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int[][] tomato = new int[N][M];
		Queue<posi> que = new LinkedList<posi>();
		
		for (int i = 0; i < N; i++) { // 토마토 입력 받음
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) {
					que.offer(new posi(i, j)); // 익은 토마토일 경우 Q에 push
				}
			}
		}
		
		// BFS
		while (!que.isEmpty()) {
			posi cur = que.poll();
			int y = cur.y;
			int x = cur.x;
			for (int dir = 0; dir < 4; dir++) { // 상하좌우 탐색
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || tomato[ny][nx] == -1) continue;
				if (tomato[ny][nx] == 0) {
					tomato[ny][nx] = tomato[y][x] + 1;
					que.offer(new posi(ny, nx));
				}
			}
		}

		int max = 0;
		point1:
		for (int i = 0; i < N; i++) { // 토마토 날짜 체크
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				else if (tomato[i][j] > max) max = tomato[i][j];
			}
		}
		System.out.println(max - 1);
	}

	static class posi {
		int y, x;
		public posi(int i, int j) {
			y = i;
			x = j;
		}
	}
}
