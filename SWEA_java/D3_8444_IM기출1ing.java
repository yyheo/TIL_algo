import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_8444_IM기출1ing {
	static int T, N, res; // N : 방의 갯수
	static int[] room, target;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			res = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			room = new int[N + 1];
			target = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				target[i] = Integer.parseInt(st.nextToken());
			}
			on(0);
			System.out.println("#" + tc + " " + res);
		}
		// 각 방에는 전원 킬 수 있는 스위치가 있음
		// 방 번호 1번부터 시작
		// 특정 방의 스위치를 키고 끄면 배수 방들도 조작됨
		// 모두 꺼진 상황에서 스위치 조작 최소 횟수 구하기
	}
	private static boolean on(int cnt) {
		if (correct()) {
			if (res > cnt) res = cnt;
			return true;
		}
		for (int i = 1; i <= N; i++) {
			// 스위치 킴
			for (int j = i; j <= N; j += i) {
				if (room[j] == 0) room[j] = 1;
				else room[j] = 0;
			}
			if (on(cnt + 1)) break;
			// 다시 원상복구
			for (int j = i; j <= N; j += i) {
				if (room[j] == 0) room[j] = 1;
				else room[j] = 0;
			}
		}
		return false;
	}
	private static boolean correct() {
		for (int i = 1; i <= N; i++) {
			if (room[i] != target[i]) {
				return false;
			}
		}
		return true;
	}
}
