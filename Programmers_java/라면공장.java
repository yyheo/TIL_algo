import java.util.Comparator;
import java.util.PriorityQueue;

public class 라면공장 {
	
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0, i = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
        while (stock < k) {
			for (; i < dates.length; i++) {
				if(dates[i] <= stock) {
					que.add(supplies[i]);
				} else {
					break;
				}
			}
			stock += que.poll();
			answer++;
		}
        return answer;
    }
  
    
	public static void main(String[] args) {
		int[] dates = {1, 2, 3, 4};
		int[] supplies = {10, 40, 30 ,20};
		int ans = solution(4, dates, supplies, 100);
		System.out.println(ans);
	}
}
