package algo.boj;import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q15650_N과M_2 {
	
	static int N, M;
	static int[] num;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[M];
		check = new boolean[N + 1];
		
		permu(0);
	}
	static void permu(int index) {
		if (index == M) {
			for (int i = 0; i < num.length - 1; i++) {
				if (num[i] > num[i + 1]) return;			// 오름차순을 위한 코드 추가
			}
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (check[i] == true) continue;
			check[i] = true;
			num[index] = i;									// 선택
			permu(index + 1);
			check[i] = false;
		}
	}
}
