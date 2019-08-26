import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1931_회의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		meeting[] meetings = new meeting[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new meeting(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(meetings, new comparator());
		
		int endTime = 0, res = 0;
		ArrayList<Integer> resList = new ArrayList<>();
		for (int i = 0; i < meetings.length; i++) {
			if (meetings[i].start < endTime) continue;
			endTime = meetings[i].end;
			res += 1;
			resList.add(meetings[i].index);
		}
		System.out.println(res);
		for (int i = 0; i < resList.size(); i++) {
			System.out.print(resList.get(i) + " ");
		}
	}
	
	static class comparator implements Comparator<meeting> {
		@Override
		public int compare(meeting o1, meeting o2) {
			int result = o1.end - o2.end;
			if (result == 0) {
				result = o1.start - o2.start;
			}
			return result;
		}
	}
	
	static class meeting {
		int index, start, end;

		public meeting(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}
	}
}
