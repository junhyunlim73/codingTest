import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Edge>[] adj;
    static int[] dist;
    static int N, M, X;
    static int INF = 1_000_000_000;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, c));
        }

        for(int i = 1; i < N + 1; i++){
            if(i == X)
                continue;

            int d = dij(i, X, 0);
            max = Math.max(max, dij(X, i, d));
        }

        System.out.println(max);
        br.close();
    }

    private static int dij(int start, int end, int d) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, d));
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = d;

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(now.v == end)
                break;

            if(dist[now.v] < now.cost)
                continue;

            for(Edge next : adj[now.v]){
                if(dist[now.v] + next.cost < dist[next.v]){
                    dist[next.v] = dist[now.v] + next.cost;
                    pq.add(new Edge(next.v, dist[next.v]));
                }
            }

        }

        return dist[end];
    }

    static class Edge implements Comparable<Edge> {
        int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

}