import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class D3_2806_NQueen {
	static int[] board;
	static int N, result;
	static void solve(int q ) {
		if( q == N ) {	// 모두 선택했으면
			result++;
			return;
		}
		for( int i=0; i<N; i++ ) {	// 모든 열 탐색
			boolean possible = true;
			for( int j=0; j<q; j++ ) {	// 이전에 지나왔던 행들 검사
				if( board[j] == i || Math.abs(q-j) == Math.abs(i-board[j]) ) {	// 같은 열이거나 대각선이면 불가능
					possible = false;
					break;
				}
			}
			if( possible ) {
				board[q] = i;	// q : index, 행을 나타냄
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
