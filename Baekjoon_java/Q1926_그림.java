package com.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1926_그림 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int N, M;
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] rand = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) { // 입력 받기
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				rand[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int numPic = 0, maxPic = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (rand[i][j] == 0 || visit[i][j] == true) continue;
				
				Queue<POSI> que = new LinkedList<POSI>();
				visit[i][j] = true;
				que.offer(new POSI(i, j));
				numPic++;
				int sizePic = 1;
				while (!que.isEmpty()) {
					POSI cur = que.poll();
					for (int dir = 0; dir < 4; dir++) {
						int ny = cur.y + dy[dir];
						int nx = cur.x + dx[dir];
						if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						if (visit[ny][nx] || rand[ny][nx] != 1) continue;
						visit[ny][nx] = true;
						que.offer(new POSI(ny, nx));
						sizePic++;
					}
				}
				if (sizePic > maxPic) maxPic = sizePic;
			}
		}
		System.out.println(numPic);
		System.out.println(maxPic);
	}

	static class POSI {
		int y, x;
		public POSI(int i, int j) {
			y = i;
			x = j;
		}
	}

}
