import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int N, M, cnt, startNode;
    static ArrayList<Edge>[] adj;
    static long mst, max;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N];
        adj = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            parents[i] = i;
            adj[i] = new ArrayList<>();
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, c));
        }

        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            int start = find(now.s);
            int end = find(now.e);

            if(start != end){
                union(start, end);
                cnt++;
                mst += now.cost;
                adj[now.s].add(new Edge(now.e, now.cost));
                adj[now.e].add(new Edge(now.s, now.cost));
            }

            if(cnt == N-1)
                break;
        }

        sb.append(mst).append("\n");

        visited = new boolean[N];
        visited[0] = true;
        dfs(0, 0);

        max = 0;
        visited = new boolean[N];
        visited[startNode] = true;
        dfs(startNode, 0);

        sb.append(max).append("\n");

        System.out.print(sb.toString());
        br.close();
    }

    private static void dfs(int start, int total){
        if(max < total){
            max = total;
            startNode = start;
        }

        for(Edge next : adj[start]){
            if(!visited[next.s]){
                visited[next.s] = true;
                dfs(next.s, total + next.cost);
            }
        }

    }

    private static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x < y)
            parents[y] = x;
        else
            parents[x] = y;
    }

    static class Edge implements Comparable<Edge>{
        int s, e, cost;

        public Edge(int s, int e, int cost){
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        public Edge(int s, int cost){
            this.s = s;
            this.cost = cost;
        }

        public int compareTo(Edge o){
            return Integer.compare(this.cost, o.cost);
        }

    }

}