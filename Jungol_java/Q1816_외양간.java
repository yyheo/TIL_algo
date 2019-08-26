import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class Q1816_외양간 {
    public static void main(String[] args) {
    	//input
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 최대 판자 수
        int S = sc.nextInt(); // 총 외양간의 수
        int C = sc.nextInt(); // 소가 들어있는 외양간의 수
        int res = 0;		  // 결과값
        int[] cow = new int[C];
        boolean[] panja = new boolean[C];
        Info[] check = new Info[C]; // 각각 외양간(cow)끼리의 차
        for (int i = 0; i < cow.length; i++) {
            cow[i] = sc.nextInt();
        }
        if (M >= C) {				// 외양간 수보다 판자수가 많으면, 외양간마다 판자를 놓을 수 있음
        	res = C;
        } else {
        	Arrays.sort(cow);		// 외양간 오름차순
            for (int i = 1; i < check.length; i++) {
                check[i] = new Info(cow[i] - cow[i - 1], i - 1);
    		}
            check[0] = new Info(0, 0);
            Arrays.sort(check, new comparator());	// 외양간끼리의 차 내림차순
            for (int i = 0; i < M - 1; i++) {		// 차가 제일 큰 곳들에 판자 끊음
                panja[check[i].posi] = true;
            }
            int start = 0;
            for (int i = 0; i < C; i++) {
                if (panja[i] == true) {
                    res += cow[i] - cow[start] + 1;
                    start = i + 1;
                }
            }
            res += cow[C - 1] - cow[start] + 1;
        }
        System.out.println(res);
    }
     
    static class comparator implements Comparator<Info> {
        @Override
        public int compare(Info o1, Info o2) {
            return o2.dif - o1.dif;
        }
    }
     
    static class Info {
        int dif, posi;
        public Info(int dif, int posi) {
            super();
            this.dif = dif;
            this.posi = posi;
        }
    }
}