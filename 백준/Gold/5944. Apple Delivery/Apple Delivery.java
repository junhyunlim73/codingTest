import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] adj;
    static int C, P, PB, PA1, PA2;
    static int INF = 2_000_000_001;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        PB = Integer.parseInt(st.nextToken());
        PA1 = Integer.parseInt(st.nextToken());
        PA2 = Integer.parseInt(st.nextToken());
        adj = new ArrayList[P + 1];

        for (int i = 1; i <= P; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < C; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj[s].add(new Node(e, weight));
            adj[e].add(new Node(s, weight));
        }

        int[] distFromPB = dij(PB);
        int[] distFromPA1 = dij(PA1);

        int dist1 = distFromPB[PA1] + distFromPA1[PA2];
        int dist2 = distFromPB[PA2] + distFromPA1[PA2];

        total = Math.min(dist1, dist2);
        System.out.println(total);
        br.close();
    }

    private static int[] dij(int start){
        int[] dist = new int[P + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int v = now.v;
            int e = now.e;

            if(dist[v] < e)
                continue;

            for(Node next : adj[v]){
                if(dist[v] + next.e < dist[next.v]){
                    dist[next.v] = dist[v] + next.e;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }

        }

        return dist;
    }

    static class Node implements Comparable<Node>{
        int v, e;

        public Node(int v, int e){
            this.v = v;
            this.e = e;
        }

        public int compareTo(Node o){
            return Integer.compare(this.e, o.e);
        }
    }
}