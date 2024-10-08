import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] adj;
    static int INF = 1_000_000_00;
    static long[] dist;
    static long[] friendA, friendB, friendC;
    static ArrayList<Integer> friends;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        friends = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            friends.add(Integer.parseInt(st.nextToken()));
        }

        adj = new ArrayList[N + 1];

        for(int i = 0; i < N + 1; i++){
            adj[i] = new ArrayList<>();
        }

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        int result = 0;  // 초기화 값을 -1로 설정
        long maxDist = 0;

        friendA = dijkstra(friends.get(0));
        friendB = dijkstra(friends.get(1));
        friendC = dijkstra(friends.get(2));

        for (int i = 1; i <= N; i++) {
            long minDist = Math.min(friendA[i], Math.min(friendB[i], friendC[i]));

            // 가장 큰 maxDist를 찾고, 그에 해당하는 노드를 선택
            if(minDist == maxDist)
                continue;

            if (minDist > maxDist) {
                maxDist = minDist;
                result = i;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static long[] dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.v] < cur.cost)
                continue;

            for(Node next : adj[cur.v]){
                if(dist[cur.v] + next.cost < dist[next.v]){
                    dist[next.v] = dist[cur.v] + next.cost;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }

    static class Node implements Comparable<Node>{
        int v;
        long cost;

        public Node(int v, long cost){
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Node n){
            return Long.compare(this.cost, n.cost);
        }
    }
}