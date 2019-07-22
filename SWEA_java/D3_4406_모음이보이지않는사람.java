package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 4406_모음이보이지않는사람 {

	static int T;
	static String str;
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			String res = "";
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'a'
						|| str.charAt(i) == 'e'
						|| str.charAt(i) == 'i'
						|| str.charAt(i) == 'o'
						|| str.charAt(i) == 'u') {
				continue;
				}
				res += str.charAt(i);
			}
			System.out.println("#" + tc + " " + res);
		}	
	}
}
