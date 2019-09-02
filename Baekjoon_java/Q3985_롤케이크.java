import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine()); // 롤케이크 길이
		int N = Integer.parseInt(br.readLine()); // 방청객의 수
		int[] cake = new int[L + 1];
		Info[] want = new Info[N]; // 방청객이 원한 갯수
		Info[] eat = new Info[N]; // 방청객이 실제로 받는 갯수
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for (int j = start; j <= end; j++) {
				if(cake[j] == 0) {
					cake[j] = i + 1;
					cnt++;
				}
			}
			want[i] = new Info(i + 1, end - start + 1);
			eat[i] = new Info(i + 1, cnt);
		}
		Arrays.sort(want, new comparator());
		System.out.println(want[0].idx); // 가장 많은 케이크를 기대한 방청객
		Arrays.sort(eat, new comparator());
		System.out.println(eat[0].idx);
	}
	static class Info {
		int idx, cnt;
		public Info(int idx, int cnt) {
			super();
			this.idx = idx;
			this.cnt = cnt;
		}
	}
	static class comparator implements Comparator<Info> {
		@Override
		public int compare(Info o1, Info o2) {
			int res = o2.cnt - o1.cnt;
			if (res == 0) res = o1.idx - o2.idx;
			return res;
		}
	}
}
