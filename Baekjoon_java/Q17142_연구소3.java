import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q17142_연구소3 {
	static int N, M;
	static int[][] initMap, map;
	static int[] virusCombi;
	static ArrayList<Posi> virus;
	static int res = 2501;
	
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 연구소의 크기
		M = Integer.parseInt(st.nextToken()); // 놓을 수 있는 바이러스 갯수
		initMap = new int[N][N];
		virus = new ArrayList();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				initMap[i][j] = Integer.parseInt(st.nextToken());
				if(initMap[i][j] == 2) {
					virus.add(new Posi(i, j));	// virus면 virus리스트에 저장
				}
			}
		}
		// 바이러스 조합
		virusCombi = new int[M]; // 조합결과를 저장할 배열
		combi(0, 0);
		if (res == 2501) System.out.println(-1); // 바이러스가 전부 못퍼졌을 경우
		else System.out.println(res);
	}
	
	private static void combi(int index, int target) {
		if (index == M || target == virus.size()) { // 조합 완료
			// 조합 완료 후 바이러스 퍼뜨리기 (현재 최소시간 넘어갈 경우 그만 퍼뜨림)
			if (index == M) goVirus();
			return;
		}
		virusCombi[index] = target;
		combi(index + 1, target + 1);
		combi(index, target + 1);
		
	}

	private static void goVirus() {
		// 임시 map 복사
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = initMap[i][j];
			}
		}
		// 활성화된 바이러스를 -1로 표시
		for (int i = 0; i < M; i++) {
			Posi curVirus = virus.get(virusCombi[i]);
			map[curVirus.y][curVirus.x] = -1;
		}
		int curTime = -1;
		while(true) {
			int zeroCheck = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if(map[y][x] == curTime) {
						if (y - 1 >= 0 && (map[y - 1][x] == 0 || map[y - 1][x] == 2)) {
							if (map[y - 1][x] == 0) zeroCheck++;
							map[y - 1][x] = curTime - 1; // 상
						}
						if (y + 1 < N && (map[y + 1][x] == 0 || map[y + 1][x] == 2)) {
							if (map[y + 1][x] == 0) zeroCheck++;
							map[y + 1][x] = curTime - 1; // 하
						}
						if (x - 1 >= 0 && (map[y][x - 1] == 0 || map[y][x - 1] == 2)) {
							if (map[y][x - 1] == 0) zeroCheck++; // 좌
							map[y][x - 1] = curTime - 1; // 좌
						}
						if (x + 1 < N && (map[y][x + 1] == 0 || map[y][x + 1] == 2)) {
							if (map[y][x + 1] == 0) zeroCheck++;
							map[y][x + 1] = curTime - 1; // 우
						}
					}
					
				}
			}
			if (zeroCheck == 0) break; // 0이 하나도 없으면 break
			curTime--;
		}
		// 0이 남아있으면 최소값 갱신하지 않음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					return;
				}
			}
		}
		// 바이러스가 모두 퍼졌으면 최소 시간 계산
		if (Math.abs(curTime) - 1 < res) {
			res = Math.abs(curTime) - 1;
		}
	}

	static class Posi {
		int y, x;
		public Posi(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
