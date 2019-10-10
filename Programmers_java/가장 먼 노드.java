import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        LinkedList<Integer>[] list = new LinkedList[n];
        int[] dist = new int[n];
        for(int i = 0; i < n; i++) {
            list[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < edge.length; i++) {
            int from = edge[i][0] - 1;
            int to = edge[i][1] - 1;
            list[from].add(to);
            list[to].add(from);
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Info> que = new LinkedList<Info>();
        dist[0] = 0;
        que.add(new Info(0, 0));
        while(!que.isEmpty()) {
            Info cur = que.poll();
            for(int i = 0; i < list[cur.node].size(); i++) {
                int next = list[cur.node].get(i);
                if(dist[next] > cur.cnt + 1) {
                    dist[next] = cur.cnt + 1;
                    que.add(new Info(next, dist[next]));
                }
            }
        }
        // max값 구하기
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = dist[i] > max ? dist[i] : max;
        }
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if (dist[i] == max) answer++;
        }
        System.out.println(Arrays.toString(dist));
        return answer;
    }
    
    static class Info {
        int node, cnt;
        public Info(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }
}