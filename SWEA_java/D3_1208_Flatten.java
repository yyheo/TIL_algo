/* SWEA 환경이 아닌 로컬에서 실행시 패키지 추가 필요
메모리 : 21,068 kb
실행시간 : 128 ms */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] map = new int[100];
		for (int tc = 1; tc <= 10; ++tc) {
			int N = Integer.parseInt(in.readLine()); // 덤프 횟수 input
			String box = in.readLine(); // 박스 높이 input
			StringTokenizer st = new StringTokenizer(box);
			
			
			// map 초기 상태
			for (int i = 0; i < 100; ++i) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = N; i > 0; --i) {
				Arrays.sort(map);
				if (map[99] - map[0] <= 1) break;
				map[99] -= 1;
				map[0] += 1;
			}
			Arrays.sort(map);
			System.out.println("#" + tc + " " + (map[99] - map[0]));
		}
	}
}
