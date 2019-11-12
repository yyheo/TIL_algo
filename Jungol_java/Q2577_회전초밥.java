package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2577_회전초밥 {
	static int N, d, k, c, result;
	static Deque<Integer> dq = new LinkedList<Integer>();
	private static int[] find;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		find = new int[3001];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			dq.add(arr[i]);
			if(find[arr[i]]++ == 0) {
				cnt++;
			}
			result = Math.max(result, cnt);
		}
		
		for (int i = 0; i < N - 1; i++) {
			dq.pollFirst();
			if((--find[arr[i]]) == 0)
				cnt--;
			dq.addLast(arr[(i + k) % N]);
			if((find[arr[(i + k) % N]])++ == 0)
				cnt++;
			if(find[c] == 0)
				result = Math.max(result, cnt + 1);
			else
				result = Math.max(result, cnt);
		}
		System.out.println(result);
	}
}
