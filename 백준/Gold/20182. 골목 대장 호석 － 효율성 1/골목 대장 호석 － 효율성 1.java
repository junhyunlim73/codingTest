import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dist;
    static int INF = 1_000_000_000;
    static int N, M, s, e, C;
    static int min = Integer.MAX_VALUE;
    static ArrayList<int[]>[] adj;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        Arrays.fill(dist, INF);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new int[] {b, c});
            adj[b].add(new int[] {a, c});
        }

        if(dijkstra(s, e) == INF)
            System.out.println(-1);
        else
            System.out.println(min);

        br.close();
    }

    private static int dijkstra(int start, int end) {
        dist[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(s, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.v == end){
                min = cur.max;
                return cur.max;
            }

            for(int[] next : adj[cur.v]) {
                int v = next[0];
                int c = next[1];
                int nextDist = dist[cur.v] + c;
                int max = Math.max(cur.max, c);

                int[] arr = {cur.v , v, c};
                Arrays.sort(arr);

                String str = "";

                for(int n : arr){
                    str += n + " ";
                }

                if(!set.contains(str) && nextDist <= C) {
                    dist[v] = nextDist;
                    set.add(str);
                    q.add(new Node(v, max));
                }

            }

        }

        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int v, max;

        public Node(int v, int max) {
            this.v = v;
            this.max = max;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.max, o.max);
        }

    }

}