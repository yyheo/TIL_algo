// 쌤이 풀어주신거 258ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D5_1247_최적경로T {
	
	static int T, N;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] check, custSeq;
	static Posi[] customer;
	static Posi company, house;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			min = 10201;
			company = new Posi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			house = new Posi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customer = new Posi[N];
			custSeq = new int[N];
			check = new int[N];
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				customer[i] = new Posi(x, y);
			}
			go(0, company.x, company.y, 0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	static void go(int count, int bx, int by, int visited, int result) {
	if (result >= min) return;
	if (count == N) { // 고객 집 다 돌았을 경우, 직전 고객과 집까지의 거리 누적
		result += Math.abs(house.x - bx) + Math.abs(house.y - by);
		if (result < min) min = result;
		return;
	}
		for (int i = 0; i < N; i++) {
			if((visited & (1<<i)) == 0) {	// 방문하지 않았으면
				go(count+1, customer[i].x, customer[i].y, 
						visited|(1<<i), result + Math.abs(customer[i].x - bx) + Math.abs(customer[i].y - by));
			}
		}
	}
	
	static class Posi {
		int y, x;
		public Posi(int x, int y) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
