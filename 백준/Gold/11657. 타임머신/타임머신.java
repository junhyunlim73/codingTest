import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Edge> edges = new ArrayList<Edge>();
    static int N, M;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, cost));
        }

        if(!BellmanFord(1)){
            System.out.println(-1);
        }else{
            for(int i = 2; i < N + 1; i++){
                if(dist[i] == Long.MAX_VALUE){
                    System.out.println(-1);
                }else{
                    System.out.println(dist[i]);
                }
            }
        }
    }

    private static boolean BellmanFord(int start){
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        for(int i = 1; i < N + 1; i++){
            for(int j = 0; j < M; j++){
                Edge edge = edges.get(j);

                if(dist[edge.start] != Long.MAX_VALUE && dist[edge.end] > edge.cost + dist[edge.start]){
                    dist[edge.end] = dist[edge.start] + edge.cost;
                }
            }
        }

        for(int i = 0; i < M; i++){
            Edge edge = edges.get(i);

            if(dist[edge.start] != Long.MAX_VALUE && dist[edge.end] > edge.cost + dist[edge.start]){
                return false;
            }

        }

        return true;
    }

    static class Edge{
        int start, end, cost;

        public Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

    }

}