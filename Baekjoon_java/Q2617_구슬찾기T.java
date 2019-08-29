import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// DFS 응용
// 쌤 풀이
public class Q2617_구슬찾기T {
	private static int N;
	private static int M;
	private static int[][] map;
	private static HashSet<Integer>[] hsWeight;
	private static HashSet<Integer>[] hsLight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());		// 1 <= N <= 99
		M = Integer.parseInt(st.nextToken());		// 1 <= M <= N(N-1) / 2
		
		map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {	// 저울에 단 회수만큼 반복
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken()); // 무거운거
			int e = Integer.parseInt(st.nextToken()); // 가벼운거
			map[s][e] = 1;
		}
		
		int cnt = 0;		// 중간이 절대로 될 수 없는 구슬 수
		int mid = ( N + 1 / 2 );	// 탈락 기준
		hsWeight = new HashSet[N+1]; // 정점 무거운
		hsLight = new HashSet[N+1]; // 정점 가벼운
		for (int i = 1; i <= N; i++) {
			// i 정점보다 큰 정점 탐색
			// 각 정점에 큰 정점의 개수, 큰 정점의 목록 (재활용을 위해서, 중복 정점을 체크하기 위해)
			int x = dfsLight(i).size();
			// i 정점보다 작은 정점 탐색\
			int y = dfsWeight(i).size();
			if (x >= mid || y >= mid) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	// 가벼운 구슬을 순회, 목록을 만들어 리턴하는 메서드
	private static HashSet<Integer> dfsLight(int v) {
		if (hsLight[v] == null) { // 저장한 적이 없을 때만
			hsLight[v] = new HashSet<Integer>();	// 객체 생성
			for (int i = 1; i <= N; i++) {
				if (map[v][i] == 1) {
					hsLight[v].add(i);	// 현재 맵에있는 (직접 관계가 있는) 정점을 담기
					hsLight[v].addAll(dfsLight(i));	// i 정점보다 더 가벼운 정점 목록 받아서 추가
				}
			}
		}
		return hsLight[v];
	}

	// 무거운 구슬을 순회, 목록을 만들어 리턴하는 메서드
	private static HashSet<Integer> dfsWeight(int v) {
		if (hsWeight[v] == null) { // 저장한 적이 없을 때만
			hsWeight[v] = new HashSet<Integer>();	// 객체 생성
			for (int i = 1; i <= N; i++) {
				if (map[i][v] == 1) {
					hsWeight[v].add(i);	// 현재 맵에있는 (직접 관계가 있는) 정점을 담기
					hsWeight[v].addAll(dfsWeight(i));	// i 정점보다 더 가벼운 정점 목록 받아서 추가
				}
			}
		}
		return hsWeight[v];
	}

}
