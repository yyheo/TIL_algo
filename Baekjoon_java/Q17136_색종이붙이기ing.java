import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17136_색종이붙이기ing {
	private static int[] paper = { 0, 5, 5, 5, 5, 5 };
	private static int[][] map;
	private static int maxSize = 0, maxR = 0, maxC = 0;
	private static int sum;

	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		
		while(sum > 0) {
			// 가로, 세로가 같은데 가장 큰 영역을 찾고 (가장 큰 정사각형 찾기)
			find();
			// 해당 사이즈와 동일한 색종이가 존재하면 덮어줌
			if (paper[maxSize] > 0) {
				paint()
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}
	
	// (r,c) 좌표에서 시작하는 size 크기의 정사각형에 val로 채우는 메소드
	private static void paint(int r, int c, int size, int num) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				m[i][j] = num;
			}
		}
	}

	private static void find() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					int min = Integer.MAX_VALUE;
					if (i - 1 >= 0 && map[i - 1][j] < min) {
						min = map[i - 1][j];
					}
					if (j - 1 >= 0 && map[i][j - 1] < min) {
						min = map[i][j - 1];
					}
					if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j - 1] < min) {
						min = map[i - 1][j - 1];
					}
					map[i][j] = min + 1;
					if(map[i][j] > maxSize) {
						maxSize = map[i][j];
						maxR = i;
						maxC = j;
					}
				}
			}
		}
	}
}
