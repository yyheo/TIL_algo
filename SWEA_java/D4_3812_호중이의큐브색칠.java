package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_3812_호중이의큐브색칠_허윤영 {
	static int T, X, Y, Z, A, B, C, N;
	static int[][][] cube;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			X = Integer.parseInt(br.readLine());
			Y = Integer.parseInt(br.readLine());
			Z = Integer.parseInt(br.readLine());
			A = Integer.parseInt(br.readLine());
			B = Integer.parseInt(br.readLine());
			C = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			long[] Adist = new long[N];
			long[] Bdist = new long[N];
			long[] Cdist = new long[N];
			long[] squareDist = new long[N];
			long[] hexahedronDist = new long[N];

			for (int i = 0; i < X; i++) {
				Adist[Math.abs(i - A) % N]++;
			}
			for (int i = 0; i < Y; i++) {
				Bdist[Math.abs(i - B) % N]++;
			}
			for (int i = 0; i < Z; i++) {
				Cdist[Math.abs(i - C) % N]++;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					squareDist[(i + j) % N] += Adist[i] * Bdist[j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					hexahedronDist[(i + j) % N] += squareDist[i] * Cdist[j];
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < hexahedronDist.length; i++) {
				System.out.print(hexahedronDist[i] + " ");
			}
			System.out.println();
		}
	}
}
