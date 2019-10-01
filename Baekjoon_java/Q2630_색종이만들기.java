package tmpAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2630_색종이만들기 {
	static int N;
	static int[][] map;
	static int[] res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		res = new int[2]; // 0 : 흰색, 1 : 파란색
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int size = N;
		boolean flag = true;
		while(flag == true && size > 0) {
			flag = false;
			for (int i = 0; i < N; i += size) {
				for (int j = 0; j < N; j += size) {
					if(map[i][j] == -1) continue;
					flag = true;
					if(isSameColor(i, j, size)) {
						checkMap(i, j, size);
					};
				}
			}
			size /= 2;
		}
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
	
	private static void checkMap(int y, int x, int size) {
		res[map[y][x]]++;
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				map[i][j] = -1;
			}
		}
	}

	private static boolean isSameColor(int y, int x, int size) {
		int color = map[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
