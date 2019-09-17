package com.ssafy.dp;

import java.util.Scanner;

// DP

public class Q1278_배낭채우기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[][] D = new int[N + 1][W + 1];
		Gift[] gift = new Gift[N + 1];
		for (int i = 1; i <= N; i++) {
			gift[i] = new Gift(sc.nextInt(), sc.nextInt());
		}
		int MAX = 0;
		// i = 선물, j = 배낭 용량
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= W; j++) {
				if (j >= gift[i].kg) {
					// 자기 무게를 뺀 만큼의 최적값을 가져와야 함
					// 선물을 1개만 쓸 수 있기 때문에 D[i]가 아닌 D[i-1]에서 가져오기
					D[i][j] = Math.max(D[i - 1][j - gift[i].kg] + gift[i].money, D[i - 1][j]);
				} else {
					D[i][j] = D[i - 1][j];
				}
				if (D[i][j] > MAX) {
					MAX = D[i][j];
				}
			}
		}
		System.out.println(MAX);
	}
	static public class Gift {
		int kg, money;
		public Gift(int kg, int money) {
			super();
			this.kg = kg;
			this.money = money;
		}
	}
}
