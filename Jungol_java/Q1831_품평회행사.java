import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// Greedy
// 행사 끝나는 시간, 시작 시간 순으로 정렬

public class Q1831_품평회행사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Event[] events = new Event[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = start + Integer.parseInt(st.nextToken());
			events[i] = new Event(start, end);
		}
		Arrays.sort(events, new comparator());
		int endTime = 0, res = 0;
		for (int i = 0; i < events.length; i++) {
			if (endTime <= events[i].start) {
				res++;
				endTime = events[i].end;
			}
		}
		System.out.println(res);
	}
	static class Event {
		int start, end;
		public Event(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
	
	static class comparator implements Comparator<Event> {
		@Override
		public int compare(Event o1, Event o2) {
			int result = o1.end - o2.end;
			if (result == 0) result = o1.start - o2.start;
			return result;
		}
	}
}
