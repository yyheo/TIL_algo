package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금_허윤영 {
	
	static int T, cntMax;
	static String[] numMap;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			numMap = st.nextToken().split("");
			cntMax = Integer.parseInt(st.nextToken());
			res = 0;
			swapDFS(0, 0);
			System.out.println("#" + tc + " " + res);
		}
	}
	
	public static void swapDFS(int cnt, int pre) {
		if (cnt == cntMax) {
			int tmp = 0;
			int weight = 1;
			for (int i = 0; i < numMap.length; i++) {
				System.out.print(numMap[i] + " ");
			}
			System.out.println();				// 테스트 출력
			for (int i = numMap.length - 1; i >= 0; i--) {
				tmp += Integer.parseInt(numMap[i]) * weight;
				weight *= 10;
			}

			if (tmp > res) {
				res = tmp;
			}
			return;
		}
		for (int i = pre; i < numMap.length; i++) {
			for (int j = i + 1; j < numMap.length; j++) {
				if (numMap[i].equals(numMap[j])) {
					swapDFS(cnt + 1, i);
				} else {
					swap(i, j);
					swapDFS(cnt + 1, i);
					swap(j, i);	// 원상복구
				}
			}
		}
	}

	public static void swap(int i, int j) {
		String tmp = numMap[i];
		numMap[i] = numMap[j];
		numMap[j] = tmp;
	}
}
