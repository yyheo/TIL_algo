import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Mock_4008_숫자만들기 {
	static int T, N; // 숫자의 개수, 3 <= N <= 12
	static int[] num;
	static char[] initOper = { '+', '-', '*', '/' };
	static char[] operator;
	static int min, max;
	static HashSet<String> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// input
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			operator = new char[N - 1];
			set = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 연산자 배열 만들어줌
			int idx = 0;
			for (int i = 0; i < 4; i++) {
				int n = Integer.parseInt(st.nextToken());
				for (int j = 0; j < n; j++) {
					operator[idx++] = initOper[i];
				}
			}
			// 숫자 배열 input
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			max = -Integer.MAX_VALUE;
			permu(0, "");
			System.out.println("#" + tc + " " + (max - min));
		}
		
	}
	
	static void permu(int idx, String s) {
		// 이미 해본 index와 상태이면 또 순열 해볼 필요가 없음. return
		// (없었을 때 시간초과 났었음)
		if (!set.add(idx + s)) {
			return;
		}
		if (idx >= N - 1) {
			// 만들어진 순열 전부 계산
			int tmp = calcul();
			// 최댓값, 최소값 계산
			if (tmp < min) {
				min = tmp;
			}
			if (tmp > max) {
				max = tmp;
			}
			return;
		}
		// 연산자 순열 만들기 (swap)
		for (int i = idx; i < N - 1; i++) {
			// swap
			char tmp = operator[i];
			operator[i] = operator[idx];
			operator[idx] = tmp;
			permu(idx + 1, s + operator[idx]);
			// swap 원상복구
			tmp = operator[i];
			operator[i] = operator[idx];
			operator[idx] = tmp;
		}
	}

	// 수식 계산하기
	private static int calcul() {
		int sum = num[0];
		for (int i = 0; i < N - 1; i++) {
			switch (operator[i]) {
			case '+':
				sum += num[i + 1];
				break;
			case '-':
				sum -= num[i + 1];
				break;
			case '*':
				sum *= num[i + 1];
				break;
			case '/':
				sum /= num[i + 1];
				break;
			}
		}
		return sum;
	}
}
