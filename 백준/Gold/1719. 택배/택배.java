import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] dist;
    static int[][] nodes;
    static ArrayList<Node>[] adj;
    static int N, M;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];
        nodes = new int[N+1][N+1];
        adj = new ArrayList[N+1];

        for(int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
            Arrays.fill(dist[i], INF);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, b, c));
            adj[b].add(new Node(a, a, c));
        }

        for(int i = 1; i < N+1; i++) {
            dijkstra(i);
        }

        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < N+1; j++) {
                if(nodes[i][j] == 0) {
                    System.out.print("- ");
                }else{
                    System.out.print(nodes[i][j] + " ");
                }
            }
            System.out.println();
        }
        
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start][start] = 0;

        for(Node next : adj[start]) {
            dist[start][next.v] = dist[start][start] + next.weight;
            nodes[start][next.v] = next.go;
            pq.offer(next);
        }

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.v;
            int w = cur.weight;
            int go = cur.go;

            if(dist[start][v] != INF && dist[start][v] < w)
                continue;

            for(Node next : adj[v]) {
                if(dist[start][v] + next.weight < dist[start][next.v]) {
                    dist[start][next.v] = dist[start][v] + next.weight;
                    nodes[start][next.v] = go;
                    pq.offer(new Node(next.v, go, dist[start][next.v]));
                }
            }
        }

    }

    static class Node implements Comparable<Node>{
        int v, go, weight;

        public Node(int v, int go, int weight) {
            this.v = v;
            this.go = go;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }

    }

}