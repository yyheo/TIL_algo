import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4013_특이한자석 {
	static int T, K;
	static int[][] magnet;
	static int[] move;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 하나의 자석이 1칸 회전될 때,
		// 붙어있는 자석은 서로 붙어있는 날의 자성과 다를 경우에만
		// 인력에 의해 반대방향으로 1칸 회전
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			magnet = new int[4][8];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 오른쪽 먼저 보기
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				// 회전시키려는 자석의 번호, 회전방향 (1 : 시계, -1 : 반시계)
				move = new int[4];
				int no = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				move[no] = dir; // 무조건 회전
				// 왼쪽 먼저 봄
				for(int left = no - 1; left >= 0; left--) {
					if(magnet[left][2] == magnet[left + 1][6]) {
						break;
					}
					move[left] = move[left + 1] * -1; // 반대 방향
				}
				
				// 오른쪽
				for(int right = no + 1; right < 4; right++) {
					if(magnet[right][6] == magnet[right - 1][2]) {
						break;
					}
					move[right] = move[right - 1] * -1; // 반대 방향
				}
				
				// move에 따라 이동시키기
				for (int j = 0; j < 4; j++) {
					if(move[j] == 1) { // 시계 방향
						int tmp = magnet[j][7];
						for (int k = 7; k > 0; k--) {
							magnet[j][k] = magnet[j][k - 1];
						}
						magnet[j][0] = tmp;
					} else if (move[j] == -1){ // 반시계 방향
						int tmp = magnet[j][0];
						for (int k = 0; k < 7; k++) {
							magnet[j][k] = magnet[j][k + 1];
						}
						magnet[j][7] = tmp;
					}
				}
			}
			// 점수 계산
			int res = 0;
			for (int i = 0; i < 4; i++) {
				if(magnet[i][0] == 1) {
					res += Math.pow(2, i);
				}
			}
			System.out.println("#" + tc + " " + res);
		}
		
	}
}
