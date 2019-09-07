import java.util.Arrays;

// 1 ~ 5까지 숫자 조합! nPr, nCr, nPn

public class permu_combi2 {
	static int N = 3;
	static int[] check = new int[N];
	static int[] num;
	
	public static void main(String[] args) {
		//makeNum();
		//permu(0);
		//combi(0, 0);
		percombi(0, 0);
	}
	
	private static void percombi(int cnt, int visited) {
		if(cnt == N) {
			System.out.println(Arrays.toString(check));
			return;
		}
		for (int i = 1; i <= 5; i++) {
			if ((1<<i & visited) == 0) {
				check[cnt] = i;
				percombi(cnt + 1, visited | 1<<i);
			}
		}
	}
	
	private static void combi(int cnt, int pre) {
		if(cnt == N) {
			System.out.println(Arrays.toString(check));
			return;
		}
		for (int i = pre + 1; i <= 5; i++) {
			check[cnt] = i;
			combi(cnt + 1, i);
		}
	}

	public static void makeNum() {
		num = new int[5];
		for (int i = 0; i < 5; i++) {
			num[i] = i + 1;
		}
	}
	
	public static void permu(int index) {
		if (index >= num.length) {
			System.out.println(Arrays.toString(num));
			return;
		}
		for (int i = index; i < num.length; i++) {
			int tmp = num[i];
			num[i] = num[index];
			num[index] = tmp;
			permu(index + 1);
			tmp = num[i];
			num[i] = num[index];
			num[index] = tmp;
		}
	}
}
