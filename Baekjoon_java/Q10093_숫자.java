import java.util.Scanner;

public class Q10093_숫자 {
	// 자료형, a와 b가 같을경우, a가 b보다 클경우 고려
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		if (a > b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		if (a == b) System.out.println(0);
		else System.out.println(b - a - 1);
		for (long i = a + 1; i < b; i++) {
			System.out.print(i + " ");
		}
	}
}
