import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D4_1211_Ladder2 {
	
	static int T, check, min;
	static int dy[] = { 0, 0, 1 };
	static int dx[] = { -1, 1, 0 }; // 醫뚯슦遺��꽣 �깘�깋
	static int map[][] = new int[100][100];
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			T = Integer.parseInt(in.readLine());
	
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int res = 0, min = 10001;
			for (int x = 0; x < 100; x++) {
				check = 0;
				go(0, x);
				if (check == 0) continue;
				if (++check <= min) {
					min = check;
					res = x;
				}
			}
			System.out.println("#" + T + " " + res);
		}
	}

	private static int go(int startY, int startX) {
		int[][] visit = new int[100][100];
		int ny, nx;
		int y = startY, x = startX;
		visit[y][x] = 1;
		while (map[y][x] == 1) {
			for (int i = 0; i < 3; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (ny >= 100 || ny < 0 || nx >= 100 || nx < 0
						|| map[ny][nx] == 0
						|| visit[ny][nx] == 1) continue;
				check += 1;
				y = ny;
				x = nx;
				visit[y][x] = 1;
				break;
			}
			
			if (y == 99) {
				return map[y][x];
			}
		}
		return 0;
	}
	
}
