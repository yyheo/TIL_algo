import java.util.Scanner;

public class Q11053_가장긴증가하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		int[] check = new int[N];
		int res = 0;
		for (int i = 1; i < num.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if(num[j] < num[i] && check[j] + 1 > max) {
					max = check[j] + 1;
				}
			}
			check[i] = max;
			if (max > res) {
				res = max;
			}
		}
		System.out.println(res + 1);
	}
}
