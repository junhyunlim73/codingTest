import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int dist[];
    static ArrayList<Solution>[] adj;
    static int N, M;
    static int INF = 1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, INF);

        for(int i = 0; i < N+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st= new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[v].add(new Solution(e, w));
            adj[e].add(new Solution(v, w));
        }

        dijkstra(1);
        System.out.println(dist[N]);
    }

    private static void dijkstra(int start){
        PriorityQueue<Solution> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Solution(start, dist[start]));

        while(!pq.isEmpty()){
            Solution curNode = pq.poll();

            if(dist[curNode.idx] < curNode.weight) continue;

            for(Solution next : adj[curNode.idx]){
                if(dist[curNode.idx] + next.weight < dist[next.idx]){
                    dist[next.idx] = dist[curNode.idx] + next.weight;
                    pq.add(new Solution(next.idx, dist[next.idx]));
                }
            }
        }

    }

}

class Solution implements Comparable<Solution>{
    int idx;
    int weight;

    public Solution(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }

    public int compareTo(Solution o) {
        return Integer.compare(this.weight, o.weight);
    }
}