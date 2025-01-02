import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M, K;
    static int[][] dist;
    static ArrayList<Edge>[] adj;
    static int[] arr;
    static int INF = 1_000_000_000;
    static int min, idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dist = new int[N+1][N+1];
            adj = new ArrayList[N+1];
            min = Integer.MAX_VALUE;
            idx = 101;

            for (int i = 1; i < N+1; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adj[a].add(new Edge(b, c));
                adj[b].add(new Edge(a, c));
            }

            K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            arr = new int[K];

            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < N+1; i++) {
                dist[i] = dijkstra(i);
                int total = 0;

                for(int n : arr){
                    total += dist[i][n];
                }

                if(total < min){
                    min = total;
                    idx = i;
                }else if(total == min){
                    idx = Math.min(idx, i);
                }

            }

            sb.append(idx).append("\n");

        }

        System.out.print(sb);
        br.close();
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if(dist[e.v] < e.e)
                continue;

            for (Edge next : adj[e.v]) {
                if(dist[e.v] + next.e < dist[next.v]) {
                    dist[next.v] = dist[e.v] + next.e;
                    pq.add(new Edge(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }

    static class Edge implements Comparable<Edge> {
        int v, e;

        public Edge(int v, int e){
            this.v = v;
            this.e = e;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.e, o.e);
        }
    }
}