import java.util.Scanner;

public class Q2999_비밀이메일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int N = s.length();
		// R <= C이고 R * C = N인 R과 C를 고름
		int R, C = 0;
		for (R = N / 2; R > 0; R--) {
			if (N / R < R) continue;
			if (N % R == 0) {
				C = N / R;
				break;
			}
		}
		char[][] arr = new char[C][R];
		int index = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[i][j] = s.charAt(index++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(arr[j][i]);
			}
		}
		System.out.println(sb.toString());
	}
}
