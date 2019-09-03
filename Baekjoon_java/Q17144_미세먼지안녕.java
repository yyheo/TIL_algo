import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17144_미세먼지안녕 {
	static int R, C, T;
	static int[][] map, tmpMap;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int upY, upX, downY, downX;
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		boolean flag = false;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 공기청정기 위, 아래 구분
				if(map[i][j] == -1 && !flag) {
					upY = i;
					upX = j;
					flag = true;
				} else if (map[i][j] == -1 && flag) {
					downY = i;
					downX = j;
				}
			}
		}
		while(T-- > 0) {
			tmpMap = new int[R][C];
			tmpMap[downY][downX] = -2;
			tmpMap[upY][upX] = -1;
			// 1. 미세먼지 확산
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] > 0) { // 미세먼지 존재시
						spread(i, j);
					}
				}
			}
			// 2. 공기청정기 작동
			airUp(upY, upX);
			airDown(downY, downX);
/*			for (int i = 0; i < R; i++) {
				System.out.println(Arrays.toString(tmpMap[i]));
			}*/
			// 원본 배열 복사
			for (int i = 0; i < R; i++) {
				map[i] = tmpMap[i].clone();
			}
		}
		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					res += map[i][j];
				}
			}
		}
		System.out.println(res);
	}
	
	
	private static void airDown(int r, int c) {
		for (int i = r + 1; i < R - 1; i++) {
			tmpMap[i][c] = tmpMap[i + 1][c];
			r++;
		}
		r++;
		for (int i = c; i < C - 1; i++) {
			tmpMap[r][i] = tmpMap[r][i + 1];
			c++;
		}
		for (int i = r; i > downY; i--) {
			tmpMap[i][c] = tmpMap[i - 1][c];
			r--;
		}
		for (int i = c; i > downX; i--) {
			tmpMap[r][i] = tmpMap[r][i - 1];
			c--;
		}
		tmpMap[r][c + 1] = 0;
	}
	
	private static void airUp(int r, int c) {
		for (int i = r - 1; i > 0; i--) {
			tmpMap[i][c] = tmpMap[i - 1][c];
			r--;
		}
		r--;
		for (int i = c; i < C - 1; i++) {
			tmpMap[r][i] = tmpMap[r][i + 1];
			c++;
		}
		
		for (int i = r; i < upY; i++) {
			tmpMap[i][c] = tmpMap[i + 1][c];
			r++;
		}
		for (int i = c; i > upX; i--) {
			tmpMap[r][i] = tmpMap[r][i - 1];
			c--;
		}
		tmpMap[r][c + 1] = 0;
	}
	private static void spread(int i, int j) {
		int sum = 0;
		for (int dir = 0; dir < 4; dir++) {
			int ny = i + dy[dir];
			int nx = j + dx[dir];
			if (ny < 0 || ny >= R || nx < 0 || nx >= C 
					|| tmpMap[ny][nx] < 0) continue;
			tmpMap[ny][nx] += map[i][j] / 5;
			sum += map[i][j] / 5;
		}
		tmpMap[i][j] += map[i][j] - sum;
	}
}
