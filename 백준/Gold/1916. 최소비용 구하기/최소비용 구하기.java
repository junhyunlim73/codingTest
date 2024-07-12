import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int Inf = 1000000001;
    static ArrayList<ArrayList<Node>> adj;
    static int[] dist;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start, end;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        dist = new int[N+1];
        Arrays.fill(dist, Inf);

        for(int i = 0; i <= N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj.get(v).add(new Node(e, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);
    }

    private static void dijkstra(int start){
        dist[start] = 0;
        pq = new PriorityQueue<>();
        pq.add(new Node(start, dist[start]));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.idx] < cur.cost)
                continue;

            for(Node next : adj.get(cur.idx)){
                if(dist[cur.idx] + next.cost < dist[next.idx]){
                    dist[next.idx] = dist[cur.idx] + next.cost;  // 거리 갱신
                    pq.add(new Node(next.idx, dist[next.idx]));  // 큐에 추가
                }
            }

        }
    }

}

class Node implements Comparable<Node> {
    int idx;
    int cost;

    public Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}