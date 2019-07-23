package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 11729_하노이탑이동순서_허윤영 {
	static int N;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		bw.write((int)Math.pow(2, N) - 1+"\n");
		move(N, 1, 3);
		bw.flush();
		bw.close();
 	}
	public static void move(int n, int cur, int target) throws IOException {
		if (n <= 1) {
			bw.write(cur + " " + target+"\n");
			return;
		}
		
		move(n - 1, cur, 6 - cur - target);
		bw.write(cur + " " + target+"\n");
		move(n - 1, 6 - cur - target, target);
		return;
	}
}
