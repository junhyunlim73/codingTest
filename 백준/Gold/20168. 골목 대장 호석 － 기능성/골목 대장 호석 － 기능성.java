import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, A, B, C;
    static ArrayList<Node>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c, 0));
            adj[b].add(new Node(a, c, 0));
        }

        System.out.println(dijkstra(A, B));
        br.close();
    }

    private static int dijkstra(int s, int e){
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(s, 0, 0));
        visited[s] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int dist = cur.dist;
            int max = cur.max;

            if(cur.v == e)
                return max;

            for(Node next : adj[cur.v]){
                int nextDist = dist + next.dist;

                if(!visited[next.v] && nextDist <= C){
                    visited[next.v] = true;
                    int newMax = Math.max(max, next.dist);
                    q.add(new Node(next.v, nextDist, newMax));
                }
            }

        }

        return -1;
    }

    static class Node implements Comparable<Node>{
        int v, dist, max;

        public Node(int v, int dist, int max){
            this.v = v;
            this.dist = dist;
            this.max = max;
        }

        public int compareTo(Node o){
            if(this.max == o.max)
                return Integer.compare(this.dist, o.dist);
            return Integer.compare(this.max, o.max);
        }

    }

}