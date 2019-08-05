package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class D3_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		Queue<Integer> que = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int num = 1;
			br.readLine();											 	// 날림
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {								// 큐에 입력 값 넣어줌
				que.offer(Integer.parseInt(st.nextToken()));
			}
			while(true) {
				int cur = que.poll();
				if (cur - num <= 0) {									// 0 이하값이 나오면 0 넣어주고 break
					que.offer(0);
					break;
				} else {
					que.offer(cur - num);
				}
				if (num == 5) num = 0; 									// 한 사이클이 돌면 초기화
				num += 1;												// 감소시킬 num값 +1
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(que.poll() + " ");
			}
			System.out.println();
		}
		
	}
}
