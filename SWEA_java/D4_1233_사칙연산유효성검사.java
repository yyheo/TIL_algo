import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int res = 1;
            int i;
            for (i = 0; i < N; i++) {
                String[] str = br.readLine().split(" ");
                if (str.length > 2) { // 자식노드가 존재
                     continue;
                } else { // 자식노드가 없음
                    if (!(str[1].charAt(0) >= '0' && str[1].charAt(0) <= '9')) {  // 말단 노드인데 숫자가 아닐 경우
                        res = 0;
                        break;
                    }
                }
            }
            for (i = i + 1; i < N; i++) {
                br.readLine();  // 날림
            }
            System.out.println("#" + tc + " " + res);
        }
    }
}