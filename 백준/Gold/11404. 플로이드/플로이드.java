import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Node>[] adj;
    static int[][] dist;
    static int INF = 100000000;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1][n+1];
        adj = new ArrayList[n+1];

        for(int i = 0; i <= n; i++){
            Arrays.fill(dist[i], INF);
        }

        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b,c));
        }

        for(int i = 1; i <= n; i++){
            dij(i);
        }

        System.out.println(sb);
    }

    private static void dij(int start){
        dist[start][start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[start][cur.idx] < cur.cost)
                continue;

            for(Node next : adj[cur.idx]){
                if(dist[start][cur.idx] + next.cost < dist[start][next.idx]){
                    dist[start][next.idx] = dist[start][cur.idx] + next.cost;
                    pq.offer(next);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            sb.append(dist[start][i] != INF ? dist[start][i] : 0).append(" ");
        }

        sb.append('\n');

    }

    static class Node implements Comparable<Node>{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}