import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int N, M, cnt, startNode;
    static ArrayList<Node>[] adj;
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
                adj[now.s].add(new Node(now.e, now.cost));
                adj[now.e].add(new Node(now.s, now.cost));
            }

            if(cnt == N-1)
                break;
        }

        sb.append(mst).append("\n");

        for(int i = 0; i < N; i++){
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, 0);
        }

        sb.append(max).append("\n");

        System.out.print(sb.toString());
        br.close();
    }

    private static void dfs(int start, int total){
        if(max < total){
            max = total;
            startNode = start;
        }

        for(Node next : adj[start]){
            if(!visited[next.v]){
                visited[next.v] = true;
                dfs(next.v, total + next.e);
                visited[next.v] = false;
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

    static class Node implements Comparable<Node>{
        int v, e;

        public Node(int v, int e){
            this.v = v;
            this.e = e;
        }

        public int compareTo(Node o) {
            return Integer.compare(o.v, this.v);
        }
    }

    static class Edge implements Comparable<Edge>{
        int s, e, cost;

        public Edge(int s, int e, int cost){
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        public int compareTo(Edge o){
            return Integer.compare(this.cost, o.cost);
        }

    }

}