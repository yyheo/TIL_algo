package algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface D3_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T, N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// N 입력
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			// 농작물 입력 & 계산
			int sum = 0;
			int num = N / 2;
			boolean flag = true;									// num이 +되어야 하는지 -되어야 하는지 체크하는 flag
			for (int i = 0; i < map.length; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < tmp.length(); j++) {
					map[i][j] = tmp.charAt(j) - '0';
					if (j >= num && j < N - num) {					// 조건에 맞으면 sum에 더해줌
						sum += map[i][j];
					}
				}
				if (flag == true && num == 0) flag = false;			// 처음으로 num이 0이 되면 flag를 false로 바꿔줌 (이후로는 num이 -가 되어야함)
				if (flag == true) num -= 1;	
				else num += 1;
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
