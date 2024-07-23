import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static ArrayList<Edge>[] adj;
    static boolean[] visited;
    static int[] dist;
    static long total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[V+1];
        visited = new boolean[V+1];
        dist = new int[V+1];

        for(int i = 1; i <= V; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, c));
            adj[b].add(new Edge(a, c));
        }

        prim(1);
        System.out.println(total);
        br.close();
    }

    private static void prim(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            if(visited[edge.idx]) continue;

            visited[edge.idx] = true;
            total += edge.weight;

            for(Edge e : adj[edge.idx]){
                if(!visited[e.idx])
                    pq.add(e);
            }

        }

    }
}

class Edge implements Comparable<Edge>{
    int idx;
    int weight;

    public Edge(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }

    public int compareTo(Edge o){
        return Integer.compare(this.weight, o.weight);
    }

}