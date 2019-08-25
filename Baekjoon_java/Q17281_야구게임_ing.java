import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class Q17281_야구게임_ing {
	static int N, max;
	static int[][] player;
	static int[] permuPl = new int[9];
	static boolean[] visit = new boolean[10];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		player = new int[N][10];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9 ; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		permu(0);
		System.out.println(max);
	}

	// 순열 만듬
	private static void permu(int index) {
		if (index == 9) {
			//System.out.println(Arrays.toString(permuPl));
			int score = game();
			//System.out.println(score);
			if (max < score) {
				max = score;
			}
			return;
		}
		if (index == 3) {
			permuPl[index] = 1;
			permu(index + 1);
		}
		for (int i = 2; i < 10; i++) {
			if (visit[i] == true) continue;
			visit[i] = true;
			permuPl[index] = i;
			permu(index + 1);
			visit[i] = false;
		}
	}

	private static int game() {
		int score = 0;
		int cur = 0;
		for (int inning = 0; inning < N; inning++) {
			int out = 0;
			boolean[] ru = new boolean[4];
			point1:
			for (int i = cur; i < 9; i++) {
				switch (player[inning][permuPl[i]]) {
				case 1: // 안타
					if(ru[2]) {
						ru[2] = false;
						ru[3] = true;
						score++;
					}
					if(ru[1]) ru[2] = true;
					if(ru[0]) ru[1] = true;
					ru[0] = true;
					break;
				case 2: // 이루타
					if(ru[2]) {
						ru[2] = false;
						ru[3] = true;
						score++;
					}
					if(ru[1]) {
						ru[1] = false;
						ru[3] = true;
						score++;
					}
					if(ru[0]) ru[2] = true;
					ru[2] = true;
					break;
				case 3: // 3루타
					if(ru[2]) {
						ru[2] = false;
						ru[3] = true;
						score++;
					}
					if(ru[1]) {
						ru[1] = false;
						ru[3] = true;
						score++;
					}
					if(ru[0]) {
						ru[0] = false;
						ru[3] = true;
						score++;
					}
					ru[2] = true;
					break;
				case 4: // 홈런
					if(ru[2]) {
						ru[2] = false;
						ru[3] = true;
						score++;
					}
					if(ru[1]) {
						ru[1] = false;
						ru[3] = true;
						score++;
					}
					if(ru[0]) {
						ru[0] = false;
						ru[3] = true;
						score++;
					}
					score++; // 타자 홈으로
					break;
				case 0: // 아웃
					out++;
					break;
				}
				if (i == 8) { // 3아웃이 발생되지 않으면 이닝이 끝나지 않음
					i = -1;
				}
				if (out == 3) {
					cur = i + 1;
					break point1;	// 아웃이 3개면 이닝 종료
				}
			}
		}
		return score;
	}
}
