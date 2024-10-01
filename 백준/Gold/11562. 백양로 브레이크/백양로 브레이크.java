import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int dist[][];
    static ArrayList<Node>[] adj;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];
        adj = new ArrayList[N+1];

        for(int i = 1; i < N + 1; i++){
            adj[i] = new ArrayList<>();
            Arrays.fill(dist[i], INF);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, 0));

            if(b == 0){
                adj[v].add(new Node(u, 1));
            }else{
                adj[v].add(new Node(u, 0));
            }
        }

        for(int i = 1; i < N + 1; i++){
            dijkstra(i);
        }

        K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(dist[s][e] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start][start] = 0;

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[start][cur.v] < cur.cost)
                continue;

            for(Node next : adj[cur.v]){
                if(dist[start][cur.v] + next.cost < dist[start][next.v]){
                    dist[start][next.v] = dist[start][cur.v] + next.cost;
                    pq.add(new Node(next.v, dist[start][next.v]));
                }
            }

        }

    }

    static class Node implements Comparable<Node>{
        int v, cost;

        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Node n){
            return Integer.compare(this.cost, n.cost);
        }
    }

}