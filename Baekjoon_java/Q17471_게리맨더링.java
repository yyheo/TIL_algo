import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17471_게리맨더링 {
	static int N;
	static int[][] map;
	static int[] parents;
	static int[] people;
	static int[] flag;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine()); // 마을의 수 N
			map = new int[N][N];
			people = new int[N];
			flag = new int[N]; // 부분집합을 위한 flag 배열
			parents = new int[N]; // union을 위한
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				people[i] = Integer.parseInt(st.nextToken());;
			}
			// 마을의 인접 정보 input
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int M = Integer.parseInt(st.nextToken());
				for (int j = 0; j < M; j++) {
					map[i][Integer.parseInt(st.nextToken()) - 1] = 1;
				}
			}
			combi(0);
			min = min == Integer.MAX_VALUE ? -1 : min;
			System.out.println(min);
	}
	// 2개 지역구로 나눌 부분집합! 구함
	public static void combi(int idx) {
		if (idx == N) {
			for (int i = 0; i < N; i++) {
				parents[i] = i;
			}
			//System.out.println(Arrays.toString(flag));
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					// 같은 지역구고, 인접한 마을끼리 union 시킴
					if (flag[i] != flag[j]) continue;
					if (map[i][j] != 1) continue;
					union(i, j);
				}
			}
			// 같은 지역구끼리 연결되어 있는지 확인
			int aRoot = -1, bRoot = -1;
			int aSum = 0, bSum = 0;
			for (int i = 0; i < N; i++) {
				if (flag[i] == 1) {
					if (aRoot == -1) {
						aRoot = find(i);
						aSum += people[i];
					} else if (aRoot != find(i)) {
						return;
					} else {
						aSum += people[i];
					}
				} else {
					if (bRoot == -1) {
						bRoot = find(i);
						bSum += people[i];
					} else if (bRoot != find(i)) {
						return;
					} else {
						bSum += people[i];
					}
				}
			}
			if (Math.abs(aSum - bSum) < min) {
				min = Math.abs(aSum - bSum);
				//System.out.println(Arrays.toString(flag));
			}
			return;
		}
		flag[idx] = 0;
		combi(idx + 1);
		flag[idx] = 1;
		combi(idx + 1);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
		}
	}
	
	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	// 조합 다 구한 후, 직접 연결되어 있거나 같은 지역구 마을통해 간접적으로 연결되어있는지 확인 (union-find..?)
	// 2개 지역구 유권자 수 차이의 최소값 구하기
}
