import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {
	
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
			permu(0);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	static void go(int startX, int startY) {
		int res = 0;
		for (int i = 0; i < custSeq.length; i++) {
			res += Math.abs(customer[custSeq[i]].x - startX) + Math.abs(customer[custSeq[i]].y - startY);
			startX = customer[custSeq[i]].x;
			startY = customer[custSeq[i]].y;
		}
		res += Math.abs(startX - house.x) + Math.abs(startY - house.y);
		if (res < min) {
			min = res;
		}
	}
	
	static void permu(int index) {
		if (index == N) {
			go(company.x, company.y);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (check[i] == 1) continue;
			check[i] = 1;
			custSeq[index] = i;					// 선택
			permu(index + 1);
			check[i] = 0;
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
