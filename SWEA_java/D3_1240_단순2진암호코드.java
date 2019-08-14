package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_D3_1240_단순2진암호코드_허윤영 {
	static int T, N, M;	
	static Map<String, Integer> password = new HashMap<String, Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		pwInput();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int i = 0, evenSum = 0, oddSum = 0, sum = 0, res = 0;
			point1:
			for (i = 0; i < N; i++) {
				String str = br.readLine();
				int check = -1, position = 1;
				for (int j = M - 1; j >= 0; j--) {
					if (str.charAt(j) == '1') {
						check = j + 1;
						break;
					}
				}
				if (check == -1) continue;					// 1을 찾았으면
				for (int j = check - 56; j < check; j += 7) {
					String pw = str.substring(j, j + 7);
					if (position == 8) {			// 마지막 자리 수
						sum += password.get(pw);
						res += password.get(pw);
						break point1;
					} else if (position % 2 == 1) {	// 홀수 자리 수
						oddSum += password.get(pw);
					} else if (position % 2 == 0) {	// 짝수 자리 수
						evenSum += password.get(pw);
					}
					res += password.get(pw);
					position += 1;
				}
			}
			for (i = i + 1; i < N; i++) br.readLine();
			sum = oddSum * 3 + evenSum + sum;
			if (sum % 10 == 0) {
				System.out.println("#" + tc + " " + res);
			} else {
				System.out.println("#" + tc + " " + 0);
			}
		}
	}
	
	
	public static void pwInput() {
		password.put("0001101", 0);
		password.put("0011001", 1);
		password.put("0010011", 2);
		password.put("0111101", 3);
		password.put("0100011", 4);
		password.put("0110001", 5);
		password.put("0101111", 6);
		password.put("0111011", 7);
		password.put("0110111", 8);
		password.put("0001011", 9);
	}
}
