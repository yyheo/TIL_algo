import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_1873_상호의배틀필드 {
	
	static int T, H, W, N;
	static char[][] map;
	static char[] str;
	static Posi car;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			car = new Posi();
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || 
							map[i][j] == '>' || map[i][j] == '<') {
						car = new Posi(i, j);
						break;
					}
				}
			}
			N = Integer.parseInt(br.readLine());
			str = new char[N];
			str = br.readLine().toCharArray();
			for (int i = 0; i < N; i++) {
				if (str[i] == 'S') {
					shoot();
				} else {
					go(str[i]);
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	private static void go(char c) {
		int dir = 0;
		char change = '?';
		switch(c) {
		case 'U':
			dir = 0;
			change = '^';
			break;
		case 'D':
			dir = 1;
			change = 'v';
			break;
		case 'L':
			dir = 2;
			change = '<';
			break;
		case 'R':
			dir = 3;
			change = '>';
			break;
		}
		int y = car.y + dy[dir];
		int x = car.x + dx[dir];
		if (y < 0 || y >= H || x < 0 || x >= W
				|| map[y][x] != '.') {
			map[car.y][car.x] = change;
			return;
		} else {
			map[car.y][car.x] = '.';
			map[y][x] = change;
			car.y = y;
			car.x = x;
		}
	}

	public static void shoot() {
		// 전차가 보는 방향 찾기
		char dirCh = map[car.y][car.x];
		int dir = 0;
		// if로 바꾸자 짧게
		switch(dirCh) {
		case '^':
			dir = 0;
			break;
		case 'v':
			dir = 1;
			break;
		case '<':
			dir = 2;
			break;
		case '>':
			dir = 3;
			break;
		}
		int y = car.y;
		int x = car.x;
		while (true) {
			y = y + dy[dir];
			x = x + dx[dir];
			if (y < 0 || y >= H || x < 0 || x >= W
					|| map[y][x] == '#') {
				// 강철 벽에 부딪히거나 게임 밖으로 나가면 아무일도 X
				break;
			} else if (map[y][x] == '*') {
				// 벽돌 벽에 부딪히면 포탄, 벽 파괴
				map[y][x] = '.';
				break;
			}
		}
	}
	
	static class Posi {
		int y, x;
		public Posi() { }
		public Posi(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
