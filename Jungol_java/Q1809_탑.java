package algo.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1809_탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<TOP> top = new Stack<TOP>();
		int[] res = new int[N];
		
		for (int i = 0; i < N; ++i) {
			int topSize = Integer.parseInt(st.nextToken());
			// 스택이 비었으면 0
			if (top.isEmpty()) {
				res[i] = 0;
				top.push(new TOP(i, topSize));
				continue;
			}
			// 큰 빌딩을 만날 때까지 pop
			if (top.peek().size >= topSize) {
				res[i] = top.peek().posi + 1;
			} else {
				while (!top.isEmpty() && !(top.peek().size >= topSize)) {
					top.pop();
				}
				if (top.isEmpty()) {
					res[i] = 0;
				} else {
					res[i] = top.peek().posi + 1;
				}
			}
			top.push(new TOP(i, topSize));
		}
		// 답 출력
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
	
	static class TOP {
		int posi, size;
		
		public TOP(int i, int topSize) {
			this.posi = i;
			this.size = topSize;
		}
	}
}
