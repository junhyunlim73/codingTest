import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Edge>[] adj;
    static int dist[];
    static int N, E;
    static int min;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b,c));
            adj[b].add(new Edge(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int path1 = dijkstra(1, v1);

        if(path1 >= INF)
            path1 = INF;
        else{
            path1 += dijkstra(v1, v2);

            if(path1 >= INF)
                path1 = INF;
            else{
                path1 += dijkstra(v2, N);

                if(path1 >= INF)
                    path1 = INF;
            }
        }

        int path2 = dijkstra(1, v2);

        if(path2 >= INF)
            path2 = INF;
        else{
            path2 += dijkstra(v2, v1);

            if(path2 >= INF)
                path2 = INF;
            else{
                path2 += dijkstra(v1, N);

                if(path2 >= INF)
                    path2 = INF;
            }
        }

        int min = Math.min(path1, path2);

        if(min >= INF)
            System.out.println(-1);
        else
            System.out.println(min);

        br.close();
    }

    private static int dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(dist[e.v] < e.w)
                continue;

            for(Edge next : adj[e.v]){
                if(dist[e.v] + next.w < dist[next.v]){
                    dist[next.v] = dist[e.v] + next.w;
                    pq.add(new Edge(next.v, dist[next.v]));
                }
            }
        }

        return dist[end];
    }

    static class Edge implements Comparable<Edge>{
        int v, w;

        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge e){
            return w - e.w;
        }
    }

}