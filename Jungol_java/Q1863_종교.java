import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1863_종교 {
	private static int n;
	private static int m;
	private static int[] check;
	static Info[] line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		check = new int[n + 1];
		line = new Info[m];
		Arrays.fill(check, -1);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			line[i] = new Info(from, to);
		}
		
		int res = n;
		for (int i = 0; i < line.length; i++) {
			if (union(line[i].a, line[i].b)) {
				res--;
			};
		}
		System.out.println(res);
	}
	
	// union : x와 y를 포함하는 두 집합을 통합하는 오퍼레이터
	private static boolean union(int a, int b) {
		// 2. find set : 자신이 속한 집합 찾기
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) { // 3. union set : 두 노드의 집합이 다르면 합치기
			check[bRoot] = aRoot;
			return true;
		}
		return false;
	}
	
	// find set : x를 포함하는 집합을 찾음
	private static int find(int a) {
		if(check[a] < 0) return a; // root노드면 자신의 번호 리턴
		// root노드가 아니면 부모노드 따라가서 루트노드 알아온다.
		// path compression : 리턴받은 루트노드의 값으로 자신의 부모로 갱신
		return check[a] = find(check[a]);
	}

	static class Info {
		int a, b;
		public Info(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
	}
}
