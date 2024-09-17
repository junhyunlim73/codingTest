import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isPrime;
    static int[] start;
    static int[] end;
    static int N;
    static int[] dist;
    static ArrayList<int[]> list;
    static ArrayList<Node>[] adj;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        start = new int[2];
        end = new int[2];
        list = new ArrayList<>();
        isPrime = new boolean[9001];
        isPrime[0] = isPrime[1] = true;

        for(int i = 2; i <= Math.sqrt(9000); i++){
            if(!isPrime[i]){
                for(int j = i * i; j < 9001; j += i){
                    isPrime[j] = true;
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        list.add(new int[]{start[0], start[1]});
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new int[]{r, c});
        }
        list.add(new int[]{end[0], end[1]});

        adj = new ArrayList[N+2];
        dist = new int[N+2];
        Arrays.fill(dist, INF);

        for(int i = 0; i < list.size(); i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < list.size(); i++){
            for(int j = i+1; j < list.size(); j++){
                int[] rc1 = list.get(i);
                int[] rc2 = list.get(j);
                int cost = (int) Math.sqrt(Math.pow(rc1[0] - rc2[0], 2) + Math.pow(rc1[1] - rc2[1], 2));

                if(!isPrime[cost]){
                    adj[i].add(new Node(j, cost));
                    adj[j].add(new Node(i, cost));
                }
            }
        }

        System.out.println(dijkstra(0, N + 1));
        br.close();
    }

    static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.v] < now.cost)
                continue;

            for(Node next : adj[now.v]){
                if(dist[now.v] + next.cost < dist[next.v]){
                    dist[next.v] = dist[now.v] + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist[end] != INF ? dist[end] : -1;
    }

    static class Node implements Comparable<Node>{
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

}