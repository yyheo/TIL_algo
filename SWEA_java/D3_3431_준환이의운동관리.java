package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 3431_준환이의운동관리 {

	static int T, L, U, X, res;
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			U = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			if (X < L) {
				res = L - X;
			} else if (X > U) {
				res = -1;
			} else {
				res = 0;
			}
			System.out.println("#" + tc + " " + res);
		}
		
	}

}
