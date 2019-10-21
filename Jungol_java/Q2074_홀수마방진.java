import java.util.Scanner;

public class Main_2074_홀수마방진_허윤영 {
	static int[][] map;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		int y = 0;
		int x = n/2;
		for (int i = 1; i <= n*n; i++) {
			map[y][x] = i;
			if (i % n == 0) {
				y++;
			} else {
				y--;
				x--;
			}
			if(y < 0) {
				y = n-1;
			}
			if(x < 0) {
				x = n-1;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
