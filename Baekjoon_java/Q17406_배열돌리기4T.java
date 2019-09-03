import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	public static int[][] A;
	public static int[][] Acopy;
	public static int[][] cycle;
	public static int[] arr;
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // A배열의 행, 3 ≤ N, M ≤ 50
		int M = Integer.parseInt(st.nextToken()); // A배열의 열
		int K = Integer.parseInt(st.nextToken()); // 회전 연산개수, 1 ≤ K ≤ 6
		
		A = new int[N+1][M+1]; // 0번째 행,열 안씀
		Acopy = new int[N+1][M+1]; // 나중에 작성하기, 복사해서 쓰기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " "); 
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()); // 1 ≤ A[i][j] ≤ 100
			}
		}
		cycle = new int[K][3];
		for (int i = 0; i < K; i++) { // 회전 연산개수
			st = new StringTokenizer(br.readLine(), " "); // r,c,s
			cycle[i][0] = Integer.parseInt(st.nextToken()); // 1 ≤ s, 1 ≤ r-s < r < r+s ≤ N, 1 ≤ c-s < c < c+s ≤ M
			cycle[i][1] = Integer.parseInt(st.nextToken());
			cycle[i][2] = Integer.parseInt(st.nextToken());
		}
		
		arr = new int[K]; 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		perm(0, K);
		
		System.out.println(min);
	} // end of main
// 순열
	public static void perm(int step, int K) {
		if (step == K) { // 종료파트
			for (int i = 0; i < A.length; i++) { // 회전작업시 원본이 손상되므로, 배열 복사하기
				Acopy[i] = A[i].clone();
			}
			for (int i = 0; i < arr.length; i++) {
				cycleA(cycle[arr[i]]);
			}
			for (int i = 1; i < Acopy.length; i++) {
// 누적합
				int sum = 0;
				for (int j = 1; j < Acopy[i].length; j++) {
					sum += Acopy[i][j];
				}
// 최소값
				if (min > sum) min = sum;
			}
		} else { // 재귀파트
//			step 이전칸은 이미 확정된 값, step 이후칸에 들어있는 숫자(=아직 사용하지 않은 숫자)
//				step 이후칸에 들어있는 숫자를 step 자리에 하나씩 넣어보자
			for (int i = step; i < K; i++) { // 사용하지 않은 숫자만큼 반복
				int temp = arr[step];
				arr[step] = arr[i];  
				arr[i] = temp;  
				perm(step+1, K);
				
				temp = arr[step];
				arr[step] = arr[i];  
				arr[i] = temp;  
			}
		}
	}
	
	public static void cycleA(int[] cycle) {
		for (int s = cycle[2]; s > 0; s--) {
			int size = s * 2 + 1; // 한행의 움직일 거리
			int r = cycle[0] - s;
			int c = cycle[1] - s;
			int temp = Acopy[r][c]; // 백업
			for (int i = 1; i < size; i++) { // 하
				Acopy[r][c] = Acopy[r+1][c];
				r++;
			}
			for (int i = 1; i < size; i++) { // 우
				Acopy[r][c] = Acopy[r][c+1];
				c++;
			}
			for (int i = 1; i < size; i++) { // 상
				Acopy[r][c] = Acopy[r-1][c];
				r--;
			}
			for (int i = 1; i < size; i++) { // 좌
				Acopy[r][c] = Acopy[r][c-1];
				c--;
			}
			Acopy[r][c+1] = temp;
		}
	}
} // end of class