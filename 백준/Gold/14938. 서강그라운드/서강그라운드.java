import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[][] dist;
    static int[] area;
    static int max = -1;
    static ArrayList<Edge>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        dist = new int[n+1][n+1];
        area = new int[n+1];
        adj = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n + 1; i++){
            area[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[s].add(new Edge(e, w));
            adj[e].add(new Edge(s, w));
        }

        for(int i = 1; i < n + 1; i++){
            int d = Dijkstra(i);
            max = Math.max(max, d);
        }

        System.out.println(max);
        br.close();
    }

    private static int Dijkstra(int start){
        int result = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start][start] = 0;
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(dist[start][e.v] != Integer.MAX_VALUE && dist[start][e.v] < e.w)
                continue;

            for(Edge next : adj[e.v]){
                if(dist[start][e.v] != Integer.MAX_VALUE && dist[start][next.v] > dist[start][e.v] + next.w){
                    dist[start][next.v] = dist[start][e.v] + next.w;
                    pq.add(new Edge(next.v, dist[start][next.v]));
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            if(dist[start][i] <= m){
                result += area[i];
            }

        }

        return result;
    }

    static class Edge implements Comparable<Edge>{
        int v, w;

        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge o){
            return w - o.w;
        }
    }

}