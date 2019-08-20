// nextPermutation 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D5_1247_최적경로T2 {
	
	static int T, N;
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
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				customer[i] = new Posi(x, y);
			}
			Arrays.sort(customer, new comparator());
			do {
				// 순열 된 customer 최종 배열에 넣기
				Posi[] total = new Posi[N + 2];
				total[0] = company;
				total[N + 1] = house;
				for (int i = 0; i < N; i++) {
					total[i + 1] = customer[i];
				}
				// min값 계산
				int res = 0;
				for (int i = 1; i < total.length; i++) {
					res += Math.abs(total[i].x - total[i - 1].x) + Math.abs(total[i].y - total[i - 1].y);
					if (res >= min) break;
				}
				if (res < min) {
					min = res;
				}
			} while (NextPermutation());
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static boolean NextPermutation() {
		// 1. 뒷쪽부터 탐색하며 교환이 필요한 자리(감소하는 모습을 보이는 시작점 i - 1) 찾기
		int i;
		for (i = customer.length - 1; i > 0; i--) {
			if (customer[i].x > customer[i - 1].x) {
				break;
			}
		}
		// i가 0이면 가장 큰 순열이므로 다음 순열이 없음
		if (i == 0) return false;
		// 2. i 위치에 다음에 올 큰 수를 뒤쪽부터 찾기
		int j;
		for (j = customer.length - 1; j >= i; j--) {
			if (customer[i - 1].x < customer[j].x) break;
		}
		// 3. i-1 위치와 j 위치 값 교환
		swap(i - 1, j);
		// 4. 바꾼위치 뒷범위 오름차순으로 재조정
		j = customer.length - 1;
		while (i < j) {
			swap(i++, j--);
		}
		//Arrays.sort(numbers, i, numbers.length);			// 메소드 사용
		return true;
	}
	
	static class comparator implements Comparator<Posi> {
		@Override
		public int compare(Posi o1, Posi o2) {
			return o1.x - o2.x;
		}
	}
	
	private static void swap(int i, int j) {
		Posi temp = customer[i];
		customer[i] = customer[j];
		customer[j] = temp;
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
