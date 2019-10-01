package tmpAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2543_타일채우기 {
	static int N, X, Y;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0, -1 }; // 상, 좌, 하, 우, 상
	static int[] dx = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new int[N + 1][N + 1];
		X = Integer.parseInt(st.nextToken()); // N(행)
		Y = Integer.parseInt(st.nextToken()); // M(열)
		map[X][Y] = -1;
		find(1, 1, N, N, X + 1, Y + 1, 0);
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				System.out.printf(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void find(int sx, int sy, int ex, int ey, int hx, int hy, int hc) {

		int mx = (sx + ex) / 2, my = (sy + ey) / 2;
		if (sx == ex) {
			map[sx][sy] = hc;
			return;
		}
		if (hx >= sx && hx <= mx && hy >= sy && hy <= my) {
			map[mx + 1][my] = 1;
			map[mx][my + 1] = 1;
			map[mx + 1][my + 1] = 1;
			find(sx, sy, mx, my, hx, hy, hc);
			find(mx + 1, sy, ex, my, mx + 1, my, 1);
			find(sx, my + 1, mx, ey, mx, my + 1, 1);
			find(mx + 1, my + 1, ex, ey, mx + 1, my + 1, 1);
		} else if (hx >= mx + 1 && hx <= ex && hy >= sy && hy <= my) {
			map[mx][my] = 2;
			map[mx + 1][my] = 2;
			map[mx + 1][my + 1] = 2;
			find(sx, sy, mx, my, mx, my, 3);
			find(mx + 1, sy, ex, my, hx, hy, hc);
			find(sx, my + 1, mx, ey, mx, my + 1, 3);
			find(mx + 1, my + 1, ex, ey, mx + 1, my + 1, 3);
		} else if (hx >= sx && hx <= mx && hy >= my + 1 && hy <= ey) {
			map[mx][my] = 3;
			map[mx][my + 1] = 3;
			map[mx + 1][my + 1] = 3;
			find(sx, sy, mx, my, mx, my, 2);
			find(mx + 1, sy, ex, my, mx + 1, my, 2);
			find(sx, my + 1, mx, ey, hx, hy, hc);
			find(mx + 1, my + 1, ex, ey, mx + 1, my + 1, 2);
		} else if (hx >= mx + 1 && hx <= ex && hy >= my + 1 && hy <= ey) {
			map[mx][my] = 4;
			map[mx + 1][my] = 4;
			map[mx][my + 1] = 4;
			find(sx, sy, mx, my, mx, my, 4);
			find(mx + 1, sy, ex, my, mx + 1, my, 4);
			find(sx, my + 1, mx, ey, mx, my + 1, 4);
			find(mx + 1, my + 1, ex, ey, hx, hy, hc);
		}
	}
}
