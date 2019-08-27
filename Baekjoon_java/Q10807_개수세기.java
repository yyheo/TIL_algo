import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10807_개수세기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] check = new int[201];
		for (int i = 0; i < N; i++) {
			check[Integer.parseInt(st.nextToken()) + 100]++;
		}
		int V = Integer.parseInt(br.readLine());
		System.out.println(check[V + 100]);
	}
}
