import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16926_배열돌리기1 {
	
	static int N, M, R;
	static int[][] arr, original;
	static int[] dy = { +1, 0, -1, 0};
	static int[] dx = { 0, +1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		original = new int[N][M];
		
		// 초기 배열값 입력                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 원본 배열에 복사해두기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				original[i][j] = arr[i][j];
			}
		}
		rotate();
		//output
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void rotate() {
		int[][] cpyArr = new int[N][M];				// 회전시켜서 저장할 배열
		// 배열 복사
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = cpyArr[i][j] = original[i][j];
			}
		}  
		
		// 명령어 갯수만큼
		for (int i = 0; i < R; i++) {
			Posi start = new Posi(0, 0);
			Posi end = new Posi(N - 1, M - 1);
			int tmp = N < M ? N : M;
			int squareNum = tmp / 2;		// 회전해야하는 사각형의 수
			for (int j = 0; j < squareNum; j++) {
				int y = start.y; int x = start.x;
				do {
					// 방향 전환
					for (int k = 0; k < 4; k++) {
						while(true) {
 							int ny = y + dy[k];
 							int nx = x + dx[k];
    							if (ny > end.y || ny < start.y || nx > end.x || nx < start.x) break;
 							cpyArr[ny][nx] = arr[y][x];
							y = ny;
 							x = nx;
 						}
					}
				} while (!(y == start.y && x == start.x));
				start.x++; start.y++;
				end.x--; end.y--;
			}
			
			// 하나의 명령어 회전이 끝나면 원본 배열에 회전한 배열 복사
			for (int y = 0; y < arr.length; y++) {
				for (int x = 0; x < arr[y].length; x++) {
 					arr[y][x] = cpyArr[y][x];
				}
			}
			//System.out.println(Arrays.toString(arr));
		}
	}
	
	static class Posi {
		int y, x;
		
		public Posi(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
