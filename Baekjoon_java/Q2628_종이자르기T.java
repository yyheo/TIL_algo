import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 쌤이 풀어주신거
// Greedy
public class Q2628_종이자르기T {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int c = Integer.parseInt(st.nextToken()); // 열, 1 <= c <= 100
		int r = Integer.parseInt(st.nextToken()); // 행, 1 <= r <= 100
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> cutR = new ArrayList<>();
		ArrayList<Integer> cutC = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int type = Integer.parseInt(st.nextToken());	// 행/열 구분
			int num = Integer.parseInt(st.nextToken());		// 자를 위치
			if (type == 0) {
				cutR.add(num);
			} else if (type == 1) {
				cutC.add(num);
			}
		}
		cutR.add(0);
		cutR.add(r);
		cutC.add(0);
		cutC.add(c);
		Collections.sort(cutR);
		Collections.sort(cutC);
		int maxR = 0;	// 최대 세로 높이 저장
		for (int i = 1; i < cutR.size(); i++) {
			if (maxR < cutR.get(i) - cutR.get(i - 1)) {
				maxR = cutR.get(i) - cutR.get(i - 1);
			}
		}
		int maxC = 0;	// 최대 가로 높이 저장
		for (int i = 1; i < cutC.size(); i++) {
			if (maxC < cutC.get(i) - cutC.get(i - 1)) {
				maxC = cutC.get(i) - cutC.get(i - 1);
			}
		}
		System.out.println(maxC * maxR);
	}
}
