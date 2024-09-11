import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Edge>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i < N + 1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, c));
            adj[b].add(new Edge(a, c));
        }

        System.out.println(prim(1));
        br.close();
    }

    private static int prim(int start){
        int mst = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(visited[e.v])
                continue;

            visited[e.v] = true;
            mst += e.w;

            for(Edge next : adj[e.v]){
                if(!visited[next.v]){
                    pq.add(next);
                }
            }
        }

        return mst;
    }
    
    static class Edge implements Comparable<Edge> {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge o) {
            return w - o.w;
        }
    }

}