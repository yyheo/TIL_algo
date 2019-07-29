package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기_허윤영 {
	static int T, res;
	static String str;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; ++tc) {
			T = Integer.parseInt(br.readLine());
			str = br.readLine();

			Stack<Character> st = new Stack<>();

			boolean check = true;
			// 한글자씩 스택에 넣으면서 비교
			for (int j = 0; j < T; j++) {
				if (str.charAt(j) == '(' ||
						str.charAt(j) == '{' ||
						str.charAt(j) == '<' ||
						str.charAt(j) == '[' ) {
					st.push(str.charAt(j));
				} else {
					if (st.size() == 0) { // stack이 비었으면 break
						check = false;
						break;
					}
					if((str.charAt(j) == ')' && st.peek() == '(')
							|| (str.charAt(j) == ']' && st.peek() == '[')
							|| (str.charAt(j) == '>' && st.peek() == '<')
							|| (str.charAt(j) == '}' && st.peek() == '{')) {// 짝이 맞으면
						st.pop();
					} else {
						break;
					}
				}
			}

			// 답 출력
			if (st.size() == 0 && check == true) {
				res = 1;
			} else {
				res = 0;
			}

			System.out.println("#" + tc + " " + res);
		}
	}
}
