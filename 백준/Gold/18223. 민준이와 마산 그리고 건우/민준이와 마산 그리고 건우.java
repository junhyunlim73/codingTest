import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dist;
    static int V, E, P;
    static int INF = 1_000_000_000;
    static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        adj = new ArrayList[V + 1];
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++){
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b,c));
            adj[b].add(new Node(a,c));
        }

        dijkstra(P);
        int dist2 = dist[V]; // P -> V

        dijkstra(1);
        int dist1 = dist[P]; // 1 -> P

        if((dist1 + dist2) == dist[V]){ // 1 -> P + P -> V == 1 -> V
            System.out.println("SAVE HIM");
        }else{
            System.out.println("GOOD BYE");
        }

        br.close();
    }

    private static void dijkstra(int start){
        Arrays.fill(dist, INF);
        dist[start] = 0;

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(start,0));

        while (!q.isEmpty()){
            Node cur = q.poll();
            int v = cur.v;
            int cost = cur.cost;

            if(dist[v] < cost)
                continue;

            for(Node next : adj[v]){
                if(dist[v] + next.cost < dist[next.v]){
                    dist[next.v] = dist[v] + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }

        }

    }

    static class Node implements Comparable<Node> {
        int v, cost;

        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}