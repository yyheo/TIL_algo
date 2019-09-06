import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
// 16 : 15 시작

public class Q16235_나무재테크ing {
	static int N, M, K; // N * N 땅. M 나무의 갯수
	static int[][] map;
	static int[][] A; // 추가될 양분
	static int[] dy = { -1, -1, -1, 0, 0, +1, +1, +1 };
	static int[] dx = { -1, 0, +1, -1, +1, -1, 0, +1 };
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		A = new int[N + 1][N + 1];
		// 양분 정보
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = 5;
			}
		}
		int energySum = 0;
		// 로봇이 추가할 양분 정보
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				energySum += A[i][j];
			}
		}
		// 나무 정보
		// map에 M개의 나무가 심어져있음 (한칸에 여러개 가능)
		Tree[] trees = new Tree[M];
		// ArrayList<Tree> trees = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			trees[i] = new Tree(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), true);
		}

		while(K-- != 0 && trees.length != 0) {
			Arrays.sort(trees, new comp()); // 나이 순으로 정렬
			// 봄 - 나무가 나이만큼 각자 칸에 있는 양분 먹고 나이 +1
			// 전에 나무랑 같은 칸이면, 남은 에너지로 먹음
			for (int i = 0; i < trees.length; i++) {
				Tree cur = trees[i];
				if (map[cur.y][cur.x] >= cur.age) { // 남은 에너지가 나이보다 많으면 먹고 나이 +1
					map[cur.y][cur.x] -= cur.age;
					cur.age++;
				} else { // 나이보다 적으면 에너지 못먹고 죽음
					trees[i].flag = false;
				}
			}
			
			// 여름 - 봄에 죽은 나무가 양분으로 변함. 죽은 나무 나이 / 2 가 그 칸에 양분으로 추가됨. 소수점 아래 버림
			for (int i = 0; i <	trees.length; i++) {
				Tree cur = trees[i];
				if (cur.flag == false) {
					map[cur.y][cur.x] += cur.age / 2;
				}
			}
			
			// 가을 - 나이가 5의 배수인 나무 번식. 8방에 나이 1인 나무 생김
			ArrayList<Tree> tmp = new ArrayList<>();
			for (int i = 0; i < trees.length; i++) {
				Tree cur = trees[i];
				if (cur.age == 0) continue;
				tmp.add(cur);
				if (cur.age % 5 == 0) {
					for (int dir = 0; dir < 8; dir++) {
						int ny = cur.y + dy[dir];
						int nx = cur.x + dx[dir];
						if (ny > N || ny < 1 || nx > N || nx < 1) continue;
						tmp.add(new Tree(ny, nx, 1, true));
					}
				}
			}
			trees = new Tree[tmp.size()];
			for (int i = 0; i < tmp.size(); i++) {
				trees[i] = tmp.get(i);
			}
			
			//Collections.sort(trees, new comp());
			if (energySum > 0) {
				// 겨울 - map 전체에 A 양분 추가
				for (int i = 0; i <= N; i++) {
					for (int j = 0; j <= N; j++) {
						map[i][j] += A[i][j];
					}
				}
			}
		}
		
		// K년 지난 후 살아있는 나무 개수 구하기
		System.out.println(trees.length);
	}
	
	static class comp implements Comparator<Tree> {
		@Override
		public int compare(Tree o1, Tree o2) {
			int res = o1.age - o2.age;
			if (res == 0) res = o1.y - o2.y;
			if (res == 0) res = o1.x - o2.x;
			return res;
		}
	}
	
	static class Tree {
		int y, x, age;
		boolean flag;
		public Tree(int y, int x, int age, boolean flag) {
			super();
			this.y = y;
			this.x = x;
			this.age = age;
			this.flag = flag;
		}
	}
}
