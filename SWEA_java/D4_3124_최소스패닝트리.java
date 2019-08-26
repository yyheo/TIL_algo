import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리_허윤영 {
	static int T, V, E, A, B, C;	// V : 정점의 개수, E : 간선의 개수, 각 간선의 정보 A B C
	static int[] parents;
	static Info[] line;
	static long res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			res = 0;
			parents = new int[V + 1];
			line = new Info[E];
			Arrays.fill(parents, -1);
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
				C = Integer.parseInt(st.nextToken());
				line[i] = new Info(A, B, C);
			}
			Arrays.sort(line, new comparator());
			for (int i = 0; i < line.length; i++) {
				if (union(line[i].a, line[i].b)) {
					res += line[i].w;
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
	
	static class comparator implements Comparator<Info> {
		@Override
		public int compare(Info arg0, Info arg1) {
			return arg0.w - arg1.w;
		}
	}
	
	static class Info {
		int a, b, w;
		public Info(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}
	
	// union : x와 y를 포함하는 두 집합을 통합하는 오퍼레이터
	private static boolean union(int a, int b) {
		// 2. find set : 자신이 속한 집합 찾기
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) { // 3. union set : 두 노드의 집합이 다르면 합치기
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}
	
	// find set : x를 포함하는 집합을 찾음
	private static int find(int a) {
		if(parents[a] < 0) return a; // root노드면 자신의 번호 리턴
		// root노드가 아니면 부모노드 따라가서 루트노드 알아온다.
		// path compression : 리턴받은 루트노드의 값으로 자신의 부모로 갱신
		return parents[a] = find(parents[a]);
	}
}
