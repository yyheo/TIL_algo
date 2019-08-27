import java.util.Scanner;

public class Q10808_알파벳개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] S = sc.next().toCharArray();
		int[] res = new int[26];
		for (int i = 0; i < S.length; i++) {
			res[S[i] - 'a']++;
		}
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
