import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로 {
	static int T, N;
	static double E;
	static int[] parents;
	static double result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			result = 0;
			N = Integer.parseInt(br.readLine());
			island[] islands = new island[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i] = new island();
				islands[i].index = i;
				islands[i].x = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i].y = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			ArrayList<Info> line = new ArrayList<>();
			for (int i = 0; i < islands.length; i++) {
				for (int j = i + 1; j < islands.length; j++) {
					// 자료형 주의..
					long distance = (long) (islands[i].x - islands[j].x) * (islands[i].x - islands[j].x)
									+ (long) (islands[i].y - islands[j].y) * (islands[i].y - islands[j].y);
					line.add(new Info(islands[i].index, islands[j].index, distance));
				}
			}
			Collections.sort(line, new comparator());
			parents = new int[N];
			Arrays.fill(parents, -1);
			int cnt = 0;
			for (int i = 0; i < line.size(); i++) {
				if (union(line.get(i).a, line.get(i).b)) {
					result += line.get(i).dis;
					cnt++;
				}
				if (cnt == N - 1) {
					break;
				}
			}
			result *= E;
			System.out.println("#" + tc + " " + Math.round(result));
			// result를 long으로 했더니 이상한 값이 나옴
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
	
	static class comparator implements Comparator<Info> {
		@Override
		public int compare(Info o1, Info o2) {
			return Long.compare(o1.dis, o2.dis);
		}
	}
	
	static class island {
		int index, y, x;
		public island() { }
		public island(int index, int y, int x) {
			super();
			this.index = index;
			this.y = y;
			this.x = x;
		}
	}
	
	static class Info {
		int a, b;
		long dis;
		public Info(int a, int b, long dis) {
			super();
			this.a = a;
			this.b = b;
			this.dis = dis;
		}
	}
}
