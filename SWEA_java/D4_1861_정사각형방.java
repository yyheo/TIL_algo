import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class D4_1861_정사각형방 {
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // input
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 순회
            int maxCnt = 0;
            int maxIdx = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    boolean[][] visited = new boolean[N][N];
                    Queue<Posi> que = new LinkedList<>();
                    que.add(new Posi(i, j));
                    visited[i][j] = true;
                    int cnt = 1;
                    while(!que.isEmpty()) {
                        Posi cur = que.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int ny = cur.y + dy[dir];
                            int nx = cur.x + dx[dir];
                            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                            if (map[ny][nx] - map[cur.y][cur.x] != 1
                                    || visited[ny][nx]) continue;
                            visited[ny][nx] = true;
                            que.add(new Posi(ny, nx));
                            cnt++;
                        }
                    }
                    if ((cnt == maxCnt && map[i][j] < maxIdx) || cnt > maxCnt) {
                        maxCnt = cnt;
                        maxIdx = map[i][j];
                    }
                }
            }
            System.out.println("#" + tc  + " " + maxIdx + " " + maxCnt);
        }
    }
     
    static class Posi {
        int y, x;
        public Posi(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }
    }
}