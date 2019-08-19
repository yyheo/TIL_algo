import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1213_String {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String target, in;
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 첫줄 날림
			target = br.readLine();
			in = br.readLine();
			int res = 0;
			for (int i = 0; i < in.length() - target.length() + 1; i++) {
				if (in.charAt(i) != target.charAt(0)) continue; // target의 첫글자 발견
				String tmp = in.substring(i, i + target.length());
				if(tmp.equals(target)) {
					res++;
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
