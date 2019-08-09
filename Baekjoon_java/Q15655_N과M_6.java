package algo.boj;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q15655_N과M_6 {

	static int N, M;
	static int[] input;
	static int[] num;
	static boolean[] check;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[M];
		input = new int[N];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {							// 입력 코드
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);										// 사전순 출력을 위해 sort
		permu(0);
		bw.flush();
		bw.close();
	}
	static void permu(int index) throws IOException {
		if (index == M) {
			for (int i = 0; i < num.length - 1; i++) {
			if (num[i] > num[i + 1]) return;			// 오름차순을 위한 코드 추가
			}
			for (int i = 0; i < num.length; i++) {
				bw.write(num[i] + " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (check[i] == true) continue;
			check[i] = true;
			num[index] = input[i];									// 선택
			permu(index + 1);
			check[i] = false;
		}
	}
}