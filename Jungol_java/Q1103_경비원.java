import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Q1103_경비원_허윤영 {
	static int M, N;
	
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int storeNum = Integer.parseInt(br.readLine());
		Info[] store = new Info[storeNum];
		for (int i = 0; i < storeNum; i++) {
			st = new StringTokenizer(br.readLine());
			store[i] = new Info(Integer.parseInt(st.nextToken())
								, Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		Info dg = new Info(Integer.parseInt(st.nextToken())
				, Integer.parseInt(st.nextToken()));
		int sum = 0;
		for (int i = 0; i < store.length; i++) {
			if (checkReverseDir(dg.dir, store[i].dir)) {	// 동근과 마주편에 있는 상점
				if(dg.dir == 1 || dg.dir == 2) { // 동근의 방향이 1, 2
					sum += Math.min(dg.x + store[i].x + N
							, M - dg.x + M - store[i].x + N);
				} else { // 동근의 방향이 3, 4
					sum += Math.min(dg.y + store[i].y + M
							, N - dg.y + N - store[i].y + M);
				}
			} else { // 동근과 옆방향에 있는 상점
				sum += Math.abs(dg.y - store[i].y) + Math.abs(dg.x - store[i].x);
			}
		}
		System.out.println(sum);
	}
	
	static boolean checkReverseDir (int dg, int st) {
		if (dg == 1) {
			if (st == 2) return true;
		} else if (dg == 2) {
			if (st == 1) return true;
		} else if (dg == 3) {
			if (st == 4) return true;
		} else if (dg == 4) {
			if (st == 3) return true;
		}
		return false;
	}
	
	static class Info {
		int dir, dis, y, x;
		public Info(int dir, int dis) {
			super();
			this.dir = dir;
			this.dis = dis;
			if (dir == 1) {
				this.y = 0;
				this.x = dis;
			} else if (dir == 2) {
				this.y = N;
				this.x = dis;
			} else if (dir == 3) {
				this.y = dis;
				this.x = 0;
			} else if (dir == 4) {
				this.y = dis;
				this.x = M;
			}
		}
	}
}
