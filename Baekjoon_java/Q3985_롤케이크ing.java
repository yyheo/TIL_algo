import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q3985_롤케이크ing {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine()); // 롤케이크 길이
		int N = Integer.parseInt(br.readLine()); // 방청객의 수
		int[] cake = new int[L];
		int[] want = new int[N]; // 방청객이 원한 갯수
		int[] eat = new int[N]; // 방청객이 실제로 받는 갯수
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for (int j = start; j <= end; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
					cnt++;
				}
			}
			want[i] = end - start + 1;
			eat[i] = cnt;
		}
		Arrays.sort(want);
		
	}
	
	static class comparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}
