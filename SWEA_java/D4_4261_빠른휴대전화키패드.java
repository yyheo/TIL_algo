package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D4_4261_빠른휴대전화키패드 {
	static int T, N;
	static String S;
	static String[] str;
	static HashMap<Character, Integer> map = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		setMap();
		for (int tc = 1; tc <= T; tc++) {
			int res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			S = st.nextToken();
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				String tmp = st.nextToken();
				String num = "";
				for (int j = 0; j < tmp.length(); j++) {
					num += map.get(tmp.charAt(j));
				}
				if(num.equals(S)) {
					res++;
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
	private static void setMap() {
		map.put('a', 2);
		map.put('b', 2);
		map.put('c', 2);
		map.put('d', 3);
		map.put('e', 3);
		map.put('f', 3);
		map.put('g', 4);
		map.put('h', 4);
		map.put('i', 4);
		map.put('j', 5);
		map.put('k', 5);
		map.put('l', 5);
		map.put('m', 6);
		map.put('n', 6);
		map.put('o', 6);
		map.put('p', 7);
		map.put('q', 7);
		map.put('r', 7);
		map.put('s', 7);
		map.put('t', 8);
		map.put('u', 8);
		map.put('v', 8);
		map.put('w', 9);
		map.put('x', 9);
		map.put('y', 9);
		map.put('z', 9);
	}
}
