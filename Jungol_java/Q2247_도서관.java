import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q2247_도서관 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Info[] info = new Info[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i] = new Info(Integer.parseInt(st.nextToken())
					, Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(info);
		int resO = 0, resX = 0;
		int startTime = info[0].start, endTime = info[0].end;
		for (int i = 1; i < info.length; i++) {
			// 학생들이 있는 시간
			if(info[i].start > endTime) { // 둘다 포함 안될경우
				if(resO < endTime - startTime) {
					resO = endTime - startTime;
				}
				if(resX < info[i].start - endTime) {
					resX = info[i].start - endTime;
				}
				startTime = info[i].start;
				endTime = info[i].end;
			} else if(info[i].start >= startTime &&
					info[i].end <= endTime) { // 둘다 포함 될경우
				continue;
			} else if(info[i].start >= startTime &&
					info[i].start <= endTime) { // 시작 시간만 포함될 경우
				endTime = info[i].end;
			} // 끝 시간만 포함 될 경우는 없음. 시작 순으로 정렬했으니까
		}
		if(resO < endTime - startTime) {
			resO = endTime - startTime;
		}
		System.out.println(resO + " " + resX);
	}
	
	static class Info implements Comparable<Info>{
		int start, end;
		public Info(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Info o) {
			return this.start - o.start;
		}
	}
}
