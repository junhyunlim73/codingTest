import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Edge>[] adj;
    static boolean[] visited;
    static int m, n;
    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            sum = 0;

            if(m == 0 && n == 0)
                break;

            adj = new ArrayList[m];
            visited = new boolean[m];

            for(int i = 0; i < m; i++) {
                adj[i] = new ArrayList<Edge>();
            }

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                adj[x].add(new Edge(y, z));
                adj[y].add(new Edge(x, z));
                sum += z;
            }

            sb.append(prim(0)).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }

    private static long prim(int start){
        long mst = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(visited[e.v])
                continue;

            visited[e.v] = true;
            mst += e.w;

            for(Edge next : adj[e.v]){
                if(!visited[next.v]){
                    pq.add(new Edge(next.v, next.w));
                }
            }

        }

        return sum - mst;
    }

    static class Edge implements Comparable<Edge>{
        int v, w;

        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge e){
            return this.w - e.w;
        }
    }
}