import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 삼성 AD 기출문제
 */
public class Main_백준_17144_미세먼지안녕 {
	private static int R;
	private static int C;
	private static int[][] m1;
	private static int[][] m2;
	private static int airY;
	private static int airX;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 행, 6 <= R <= 50
		C = Integer.parseInt(st.nextToken()); // 열, 6 <= C <= 50
		int T = Integer.parseInt(st.nextToken()); // 시간, 1 <= T <= 1,000
		
		m1 = new int[R][C]; // 원본
		m2 = new int[R][C]; // 작업공간
		airY = -1; // 공기청정기 행 첫번째 좌표
		airX = -1; // 공기청정기 열
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				m1[i][j] = Integer.parseInt(st.nextToken()); // -1 <= 먼지 <= 1,000
				if (airY == -1 && m1[i][j] == -1) {
					airY = i;
					airX = j;
				}
			}
		}
		for (int i = 0; i < T; i++) { // 타임만큼 반복, m1(원본) => m2(작업공간)
			// 작업공간 배열 초기화
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					m2[r][c] = 0;
				}
			}
			m2[airY  ][airX] = -1; // 공기청정기 위치
			m2[airY+1][airX] = -1;
			
//	1단계 확산
			확산();
//	2단계 순환 - 상단, 하단
			상단순환();
			하단순환();
			
			// m1 <-> m2 swap
			int [][] temp = m1;
			m1 = m2;
			m2 = temp;
		}
		
		// 먼지의 합구하기
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += m1[i][j];
			}
		}
		System.out.println(sum + 2); // 공기청정기까지 더해서 2를 보정한다
	} // end of main
	public static void 확산() { // m1원본 배열을 읽어서 m2에 작업
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (m1[r][c]==0 || m1[r][c]==-1) continue; // 먼지가 없는 경우, 공기청정기인 경우
				int v = m1[r][c] / 5; // 인접칸에 퍼트릴 값
				int cnt = 0; // 퍼트린 회수
				if (0 <= r-1 && m2[r-1][c] != -1) { // 상
					m2[r-1][c] += v;
					cnt++;
				}
				if (r+1 < R && m2[r+1][c] != -1) { // 하
					m2[r+1][c] += v;
					cnt++;
				}
				if (0 <= c-1 && m2[r][c-1] != -1) { // 좌
					m2[r][c-1] += v;
					cnt++;
				}
				if (c+1 < C && m2[r][c+1] != -1) { // 우
					m2[r][c+1] += v;
					cnt++;
				}
				m2[r][c] += m1[r][c] - cnt * v;
			}
		}
	}
	public static void 상단순환() {
		int r = airY -1; // 공기청정기(위), 초기 시작위치를 공기청정기 -1
		int c = airX;
		for (; 0 <= r-1; r--) { // 상
			m2[r][c] = m2[r-1][c];
		}
		for (; c+1 < C; c++) { // 우
			m2[r][c] = m2[r][c+1];
		}
		for (; r+1 <= airY; r++) { // 하, 공기청정기 행까지 내려오기
			m2[r][c] = m2[r+1][c];
		}
		for (; 1 <= c-1; c--) { // 좌, 공기청정기 전까지, -1가 복사되지 않도록 주의
			m2[r][c] = m2[r][c-1];
		}
		m2[r][c] = 0; // 공기청정기에서 나온 값
	}
	public static void 하단순환() {
		int r = airY + 2; // 공기청정기(아래 +1), 초기 시작위치를 공기청정기 +1
		int c = airX;
		for (; r+1 < R; r++) { // 하
			m2[r][c] = m2[r+1][c];
		}
		for (; c+1 < C; c++) { // 우
			m2[r][c] = m2[r][c+1];
		}
		for (; airY+1 <= r-1; r--) { // 상, 공기청정기 행까지 올라오기
			m2[r][c] = m2[r-1][c];
		}
		for (; 1 <= c-1; c--) { // 좌, 공기청정기 전까지, -1가 복사되지 않도록 주의
			m2[r][c] = m2[r][c-1];
		}
		m2[r][c] = 0; // 공기청정기에서 나온 값
	}
} // end of class
































