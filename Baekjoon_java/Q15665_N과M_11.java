import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q15665_N과M_11 {

	static int N, M;
	static boolean[] input;
	static int[] num;
	//static boolean[] check;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[M];
		input = new boolean[10001];
		//check = new boolean[9];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {							// 입력 코드
			int tmp = Integer.parseInt(st.nextToken());
			input[tmp] = true;
		}
		permu(0);
		bw.flush();
		bw.close();
	}
	static void permu(int index) throws IOException {
		if (index == M) {
/*			for (int i = 0; i < num.length - 1; i++) {
			if (num[i] > num[i + 1]) return;			// 비내림차순을 위한 코드 추가
			}*/
			for (int i = 0; i < num.length; i++) {
				bw.write(num[i] + " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = 1; i < 10001; i++) {
			if (input[i] == false) continue;
			//if (check[i] == true) continue;
			//check[i] = true;
			num[index] = i;									// 선택
			//input[i] -= 1;
			permu(index + 1);
			//input[i] += 1;
			//check[i] = false;
		}
	}
}
	