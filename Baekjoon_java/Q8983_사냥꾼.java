import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q8983_사냥꾼 {
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] sa = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sa[i] = Integer.parseInt(st.nextToken());
		}
		// 사대 x순으로 정렬
		Arrays.sort(sa);
		Posi[] animal = new Posi[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			animal[i] = new Posi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// 동물 x, y 순으로 정렬
		Arrays.sort(animal);
		int res = 0, cur = 0;
		// 동물들을 하나씩 보면서 가장 가까운 양쪽 사대에 잡히는지 보기
		// 이 양쪽 사대에 잡히지 않을 경우에는 그 외 사대를 볼 필요가 없음 (어짜피 거리가 더 늘어나기 때문에)
		// 마찬가지로 다음 동물부터는 이전 동물과 가까웠던 사대부터 탐색 (그 이전꺼는 어짜피 제일 가까운게 아님!!)
		for (int i = 0; i < animal.length; i++) {
			// 동물 왼쪽에 가장 가까이 있는 사대 찾기
			for (int j = cur + 1; j < sa.length; j++) { // j를 cur + 1이 아닌 cur로 했을 때 정올 테케 1개 TLE
				if(sa[j] > animal[i].x) break;
				cur = j;
			}
			// 왼쪽 사대에서 동물 잡을 수 있는지
			if (Math.abs(animal[i].x - sa[cur]) + animal[i].y <= L) {
				res++;
			} else { // 안되면 오른쪽 사대 보기
				if (cur + 1 < sa.length
						&& Math.abs(animal[i].x - sa[cur + 1]) + animal[i].y <= L) {
					res++;
				}
			}
		}
		System.out.println(res);
	}
	static class Posi implements Comparable<Posi> {
		int y, x;
		public Posi(int x, int y) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Posi o) {
			int res = this.x - o.x;
			if (res == 0) res = this.y - o.y;
			return res;
		}
	}
}
