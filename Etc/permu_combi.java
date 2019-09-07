import java.util.Arrays;

// 배열에 있는 숫자 조합! nPr, nCr, nPn

public class permu_combi {
	static int[] num = { 5, 6, 7 };
	static int[] check = new int[3];
	static int N = 3;
	
	public static void main(String[] args) {
		permu(0);
		//combi(0, -1);
		//percombi(0, 0);
	}

	// 순열 + 조합 nPr
	private static void percombi(int cnt, int visited) {
		if (cnt >= N) {
			System.out.println(Arrays.toString(check));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if ((visited & 1 << i) == 0) {
				check[cnt] = num[i];
				percombi(cnt + 1, visited | 1<<i);
			}
		}
	}

	// 조합 nCr
	private static void combi(int cnt, int pre) {
		if (cnt >= N) {
			System.out.println(Arrays.toString(check));
			return;
		}
		for (int i = pre + 1; i < num.length; i++) {
			check[cnt] = num[i];
			combi(cnt + 1, i);
		}
	}

	// 순열 nPn
	private static void permu(int index) {
		if(index >= num.length) {
			System.out.println(Arrays.toString(num));
			return;
		}
		for (int i = index; i < num.length; i++) {
			// swap
			int tmp = num[i];
			num[i] = num[index];
			num[index] = tmp;
			permu(index + 1);
			// swap
			tmp = num[i];
			num[i] = num[index];
			num[index] = tmp;
		}
	}
}
