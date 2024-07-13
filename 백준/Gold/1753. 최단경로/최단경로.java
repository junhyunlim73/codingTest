import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static ArrayList<Node>[] adj;
    static int[] dist;
    static PriorityQueue<Node> pq;
    static int INF = 1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[V + 1];
        dist = new int[V + 1];

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < V + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[v].add(new Node(u, cost));
        }

        Arrays.fill(dist, INF);
        dij(start);

        for(int i = 1; i <= V; i++){
            if(dist[i] == INF){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }

        br.close();
    }

    private static void dij(int start){
        pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, dist[start]));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.idx] < cur.cost)
                continue;

            for(Node next : adj[cur.idx]){
                if(dist[cur.idx] + next.cost < dist[next.idx]){
                    dist[next.idx] = dist[cur.idx] + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }

        }

    }
}

class Node implements Comparable<Node>{
    int cost;
    int idx;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    public int compareTo(Node n){
        return Integer.compare(this.cost, n.cost);
    }
}