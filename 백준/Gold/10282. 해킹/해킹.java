import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static ArrayList<Edge>[] adj;
    static int[] dist;
    static int INF = 1000000001;
    static int cnt, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            cnt = 0;
            time = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj = new ArrayList[n+1];
            dist = new int[n+1];

            for(int j = 0 ; j < n + 1; j++){
                adj[j] = new ArrayList<>();
            }

            for(int j = 0; j < d; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                adj[b].add(new Edge(a,s));
            }

            Arrays.fill(dist, INF);
            dij(c);

            for(int j = 1; j < n+1; j++){
                if(dist[j] != INF){
                    cnt++;
                    time = Math.max(dist[j], time);
                }
            }

            sb.append(cnt + " " + time).append("\n");
        }
        System.out.println(sb);
    }

    private static void dij(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge(start, dist[start]));

        while(!pq.isEmpty()){
            Edge curNode = pq.poll();

            if(dist[curNode.idx] < curNode.weight) continue;

            for(Edge nextNode : adj[curNode.idx]){
                if(dist[curNode.idx] + nextNode.weight < dist[nextNode.idx]){
                    dist[nextNode.idx] = dist[curNode.idx] + nextNode.weight;
                    pq.add(new Edge(nextNode.idx, dist[nextNode.idx]));
                }
            }

        }

    }

}

class Edge implements Comparable<Edge>{
    int idx;
    int weight;

    public Edge(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }

    public int compareTo(Edge o){
        return Integer.compare(this.weight, o.weight);
    }
}