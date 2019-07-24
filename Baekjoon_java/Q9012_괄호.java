package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012_괄호 {
	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		String str;
		for (int i = 0; i < T; i++) {
			Stack<Character> st = new Stack<>();
			str = br.readLine();
			boolean check = true;
			
			// 한글자씩 스택에 넣으면서 비교
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					st.push(str.charAt(j));
				} else {
					if (st.size() == 0) {
						check = false;
						break;
					}
					st.pop();
				}
			}
			
			// 답 출력
			if (st.size() == 0 && check == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
