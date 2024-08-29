import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] adj;
    static long[] dist;
    static int N, M;
    static int[] eyes;
    static long INF = 10_000_000_000L;
    static PriorityQueue<Node> pq = new PriorityQueue<Node>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N];
        eyes = new int[N];
        adj = new ArrayList[N];
        Arrays.fill(dist, INF);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            eyes[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, t));
            adj[b].add(new Node(a, t));
        }

        dijkstra(0);

        System.out.println(dist[N - 1] == INF ? -1 : dist[N - 1]);
        br.close();
    }

    private static void dijkstra(int start) {
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dist[cur.vertex] < cur.weight)
                continue;

            for(Node next : adj[cur.vertex]) {
                if(dist[cur.vertex] + next.weight < dist[next.vertex] && (next.vertex == N - 1 || eyes[next.vertex] != 1)) {
                    dist[next.vertex] = dist[cur.vertex] + next.weight;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }

        }

    }

    static class Node implements Comparable<Node>{
        int vertex;
        long weight;

        public Node(int vertex, long weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        public int compareTo(Node n){
            return Long.compare(this.weight, n.weight);
        }
    }

}