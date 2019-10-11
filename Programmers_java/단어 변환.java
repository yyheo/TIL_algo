import java.util.*;

// BFS

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Info> que = new LinkedList<Info>();
        que.add(new Info(begin, 0));
        while(!que.isEmpty()) {
            Info cur = que.poll();
            if (cur.str.equals(target)) {
                return cur.cnt;
            }
            for(int i = 0; i < words.length; i++) {
            int diff = 0;
                for(int j = 0; j < cur.str.length(); j++) {
                    if (cur.str.charAt(j) != words[i].charAt(j)) {
                        diff++;
                    }
                }
                if (diff == 1 && !visited[i]) {
                    visited[i] = true;
                    que.add(new Info(words[i], cur.cnt + 1));
                }
            }       
        }
        return 0;
    }
    
    static class Info {
        String str;
        int cnt;
        public Info(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
}