import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int N, R;
    static int[][] dist;
    static ArrayList<Node>[] adj;
    static final int INF = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][2];
        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            Arrays.fill(dist[i], INF);
        }

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int nDist = Math.max(0, e - 10); // 음수 방지
            int cost = c + (nDist * d);

            adj[a].add(new Node(b, cost));
        }

        dijkstra(1);

        if (dist[N][0] == INF) {
            System.out.println("It is not a great way.");
        } else {
            System.out.println(dist[N][0] + " " + dist[N][1]);
        }

        br.close();
    }

    static private void dijkstra(int start) {
        dist[start][0] = 0;
        dist[start][1] = 1;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.v][0] < cur.cost) continue;

            for (Node next : adj[cur.v]) {
                int newCost = dist[cur.v][0] + next.cost;
                if (newCost < dist[next.v][0] ||
                    (newCost == dist[next.v][0] && dist[cur.v][1] + 1 < dist[next.v][1])) {
                    dist[next.v][0] = newCost;
                    dist[next.v][1] = dist[cur.v][1] + 1;
                    pq.add(new Node(next.v, newCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}