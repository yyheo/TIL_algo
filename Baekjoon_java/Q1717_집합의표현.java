import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1717_집합의표현 {
	private static int[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		check = new int[n + 1];
		// check array fill
		for (int i = 0; i < n + 1; i++) {
			check[i] = i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int flag = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (flag == 0) {
				union(a, b);
			} else {
				String res = find(a) == find(b) ? "YES" : "NO";
				System.out.println(res);
			}
		}
	}

	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			check[rootB] = rootA;
			return true;
		}
		return false;
	}
	public static int find(int a) {
		if(check[a] == a) return a;
		return check[a] = find(check[a]);
	}
}
