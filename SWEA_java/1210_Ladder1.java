package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1_허윤영 {
	
	static int T;
	static int dy[] = { 0, 0, 1 };
	static int dx[] = { -1, 1, 0 }; // 좌우부터 탐색
	static int map[][] = new int[100][100];
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			T = Integer.parseInt(in.readLine());
	
			// 사다리 map 초기화
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int res = 0;
			// 시작점마다 출발
			for (int x = 0; x < 100; x++) {
				if (go(0, x) == 2) {
					res = x;
					break;
				};
			}
			
			System.out.println("#" + T + " " + res);
		}
	}

	private static int go(int startY, int startX) {
		int[][] visit = new int[100][100];
		int ny, nx;
		int y = startY, x = startX;
		visit[y][x] = 1;
		while (map[y][x] == 1) {
			for (int i = 0; i < 3; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (ny >= 100 || ny < 0 || nx >= 100 || nx < 0
						|| map[ny][nx] == 0
						|| visit[ny][nx] == 1) continue;
				y = ny;
				x = nx;
				visit[y][x] = 1;
				break;
			}
			
			if (y == 99) {
				return map[y][x];
			}
		}
		return 0;
	}
	
}
