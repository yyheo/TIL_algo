package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1175_주사위던지기2 {
	static int N, M;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		makeSubSetSum(0, 0, 0, "");
		bw.flush();
		bw.close();
	}

	public static void makeSubSetSum(int index, int cnt, int sum, String result) throws IOException {
		// 가지치기
		if (sum > M) {
			return;
		}
		
		if (cnt >= N || index > 6) {
			if (sum == M && cnt == N) {
				bw.write(result + "\n");
			}
			return;
		}
		for (int i = 1; i <= 6; i++) {
			makeSubSetSum(i, cnt + 1, sum + i, result + Integer.toString(i) + " ");
		}
	}
}
