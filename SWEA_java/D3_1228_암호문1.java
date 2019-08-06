package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class D3_1228_암호문1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list;
		String command;
		
		int N, M, X, Y;
		for (int tc = 1; tc <= 10; ++tc) {
			N = Integer.parseInt(br.readLine());
			list = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				command = st.nextToken();
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				for (int j = 0; j < Y; j++) {
					list.add(X++, Integer.parseInt(st.nextToken()));
				}
			}
			
			bw.write("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				bw.write(list.get(i) + " ");
			}
            bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}
