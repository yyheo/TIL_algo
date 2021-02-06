import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
	public static int solution(int[][] jobs) {
		int sum = 0;
		int time = 0;
		int i = 0;
		Arrays.sort(jobs, new comparator());
		PriorityQueue<Job> pque = new PriorityQueue<>();
		while(i < jobs.length) {
			for (; i < jobs.length; i++) {
				if(jobs[i][0] <= time) {
					pque.add(new Job(jobs[i][0], jobs[i][1]));
				} else {
					break;
				}
			}
			if(pque.isEmpty()) {
				time++;
			} else {
				Job cur = pque.poll();
				sum += time - cur.start + cur.run;
				time += cur.run;
			}
		}
		while(!pque.isEmpty()) {
			Job cur = pque.poll();
			sum += time - cur.start + cur.run;
			time += cur.run;
		}
		return (sum / jobs.length);
	}
	public static class comparator implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0] - o2[0];
		}
	}
	public static class Job implements Comparable<Job>{
		int start, run;
		public Job(int start, int run) {
			super();
			this.start = start;
			this.run = run;
		}
		@Override
		public int compareTo(Job o) {
			int res = this.run - o.run;
			return res;
		}
	}
	public static void main(String[] args) {
		int[][] jobs = { {0, 3}, {4, 4}, {5, 3}, {4, 1}};
		System.out.println(solution(jobs));
	}
	
}
