import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149_RGB거리 {
	static int N;
	static int[][] color;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		color = new int[3][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		color[0][0] = Integer.parseInt(st.nextToken()); // R
		color[1][0] = Integer.parseInt(st.nextToken()); // G
		color[2][0] = Integer.parseInt(st.nextToken()); // B
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			color[0][i] = r + Math.min(color[1][i-1], color[2][i-1]); // G, B만
			color[1][i] = g + Math.min(color[0][i-1], color[2][i-1]); // R, B만
			color[2][i] = b + Math.min(color[0][i-1], color[1][i-1]); // R, G만
		}
		System.out.println(Math.min(color[0][N-1], Math.min(color[1][N-1], color[2][N-1])));
	}
}
