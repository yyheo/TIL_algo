import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1828_냉장고 {
	 public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        Info[] ref = new Info[N];
	        for (int i = 0; i < N; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            ref[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	        }
	        int res = 1;
	        Arrays.sort(ref);
	        for (int i = 0; i < N - 1; i++) {
	            // i + 1의 최소값은 무조건 i의 최소값보다 크거나 같음
	            if (ref[i].min <= ref[i + 1].min
	                    && ref[i].max >= ref[i + 1].max) { // i냉장고의 범위 안에 i+1냉장고가 포함 될 경우 냉장고 범위 i+1로
	                continue;
	            } else if (ref[i].min <= ref[i + 1].min
	                    && ref[i].max >= ref[i + 1].min) { // 최소값만 포함 될 경우
	                ref[i + 1].max = ref[i].max;
	            } else { // 둘 다 포함하지 않을 경우 냉장고 추가
	                res++;
	            }
	        }
	        System.out.println(res);
	    }
	     
	     
	    static class Info implements Comparable<Info>{
	        int min, max;
	        public Info(int min, int max) {
	            super();
	            this.min = min;
	            this.max = max;
	        }
	        @Override
	        public int compareTo(Info o) {
	            return this.min - o.min;
	        }
	    }
}
