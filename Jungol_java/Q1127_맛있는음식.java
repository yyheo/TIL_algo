import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1127_맛있는음식 {
	static int N, S, B;
	static int min = 1000000001;
	static Food[] food;
	
	public static void main(String[] args) throws IOException {
		// N : 재료의 수, S : 신맛, B : 쓴 맛
		// 신맛의 합 = 선택된 재료의 신맛 지수들을 곱한 값
		// 쓴맛의 합 = 선택된 재료의 쓴맛 지수들을 더한 값
		// 신맛의 합과 쓴맛의 합의 차가 최소가 되도록
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		N = Integer.parseInt(br.readLine());
		food = new Food[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			food[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		combi(0, 0, 1, 0);
		System.out.println(min);
	}
	
	public static void combi(int index, int cnt, int S, int B) {
		if (index >= N) { // 조합 완료
			int sum = Math.abs(S - B);
			// 하나 이상의 재료를 선택해야 함
			if (sum < min && cnt != 0) {
				min = sum;
			}
			return;
		}
		combi(index + 1, cnt + 1, S * food[index].S, B + food[index].B);	// 선택
		combi(index + 1, cnt, S, B);	// 선택 X
	}
	
	static class Food {
		int S, B;
		public Food(int s, int b) {
			super();
			S = s;
			B = b;
		}
	}
}
