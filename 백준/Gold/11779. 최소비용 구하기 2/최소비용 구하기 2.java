import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int dist[];
    static ArrayList<Node>[] adj;
    static int cnt;
    static String path;
    static int d;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        dist = new int[N+1];
        adj = new ArrayList[N+1];

        for(int i = 1; i < N+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c, 1, ""));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

        sb.append(d).append("\n");
        sb.append(cnt).append("\n");
        sb.append(path);

        System.out.print(sb);
        br.close();
    }

    private static void dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        d = dist[end];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        String p = String.valueOf(start);
        pq.add(new Node(start, 0, 1, p));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.v == end && dist[cur.v] < d){
                cnt = cur.cnt;
                path = cur.p;
                d = dist[cur.v];
            }

            if(dist[cur.v] < cur.w)
                continue;

            for(Node next : adj[cur.v]) {
                if(dist[cur.v] + next.w < dist[next.v]) {
                    dist[next.v] = dist[cur.v] + next.w;
                    pq.add(new Node(next.v, dist[next.v], cur.cnt + 1, cur.p + " " + next.v));
                }
            }
        }

    }

    static class Node implements Comparable<Node>{
        int v, w, cnt;
        String p;

        public Node(int v, int w, int cnt, String p) {
            this.v = v;
            this.w = w;
            this.cnt = cnt;
            this.p = p;
        }

        public int compareTo(Node n){
            return Integer.compare(this.w, n.w);
        }
    }

}