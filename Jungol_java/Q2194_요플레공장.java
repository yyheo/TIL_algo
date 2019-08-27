import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2194_요플레공장 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N : 공장 운영 주, S : 우유 1리터당 보관 비용
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		Info[] milk = new Info[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			milk[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		long res = 0;
		for (int i = 0; i < milk.length; i++) {
			for (int j = i + 1; j < milk.length; j++) {
				if (milk[i].C + (S * (j - i)) < milk[j].C) { // 보관비용을 다 합해도 쌀 경우
					res += (milk[i].C + (S * (j - i))) * milk[j].Y;
					milk[j].Y = 0;
				}
			}
			// 해당 주차 우유 삼
			res += milk[i].C * milk[i].Y;
		}
		System.out.println(res);
	}
	
	// C : 1리터당 비용, Y : 필요한 우유
	static class Info {
		int C, Y;
		public Info(int c, int y) {
			super();
			C = c;
			Y = y;
		}
	}

}
