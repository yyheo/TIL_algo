import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class D3_2806_NQueen {
	static int[] board;
	static int N, result;
	static void solve(int q ) {
		if( q == N ) {
			result++;
			return;
		}
		for( int i=0; i<N; i++ ) {
			boolean possible = true;
			for( int j=0; j<q; j++ ) {
				if( board[j] == i || Math.abs(q-j) == Math.abs(i-board[j]) ) {
					possible = false;
					break;
				}
			}
			if( possible ) {
				board[q] = i;
				solve(q+1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			board = new int[N];
			result = 0;
			solve(0);
			System.out.format("#%d %d\n", tc, result);
		}
	}
}
