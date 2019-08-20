import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 선생님 풀이

public class D3_2806_NQueen2 {
	
	static int size, res;
	static boolean[] col, slash, bSlash;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			res = 0;
			size = sc.nextInt();
			
			col = new boolean[size + 1];
			slash = new boolean[2 * size + 1]; // 좌하향
			bSlash = new boolean[2 * size]; // 우하향
			tryQueen(1);
			System.out.println("#" + tc + " " + res);
		}
	}
	static void tryQueen(int row) {
		if (row > size) {
			res++;
			return;
		}
		// 현재 행의 모든 열에 놓아보는 시도
		for (int i = 1; i <= size; i++) {
			if (col[i] // 열체크
					|| slash[row + i] // 좌하향 대각선 체크
							|| bSlash[row - i + size]) continue; // 우하향 대각선 체크
			col[i] = slash[row + i] = bSlash[row - i + size] = true;
			tryQueen(row + 1);
			col[i] = slash[row + i] = bSlash[row - i + size] = false;
		}
	}
}