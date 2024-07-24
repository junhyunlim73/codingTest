import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Edge>[] adj;
    static boolean[] visited;
    static ArrayList<int[]> path;
    static int N, M, K;
    static boolean flag = false;
    static long[] weights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        weights = new long[K];
        path = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(new Edge(y, i + 1));
            adj[y].add(new Edge(x, i + 1));
            path.add(new int[]{x, y, i + 1});
        }

        for(int i = 0; i < K; i++){
            if(!flag){
                visited = new boolean[N + 1];

                if(i != 0){
                    int[] arr = path.get(i-1);
                    adj[arr[0]].remove(new Edge(arr[1], arr[2]));
                    adj[arr[1]].remove(new Edge(arr[0], arr[2]));
                }

                weights[i] = prim(1);

                if(!isVisited(visited)){
                    flag = true;
                    weights[i] = 0;
                }

            }

        }

        for(int i = 0; i < K; i++){
            System.out.print(weights[i] + " ");
        }

    }

    private static long prim(int start) {
        long total = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(visited[e.vertex]) continue;

            total += e.weight;
            visited[e.vertex] = true;

            for(Edge next : adj[e.vertex]){
                if(!visited[next.vertex])
                    pq.add(new Edge(next.vertex, next.weight));
            }

        }

        return total;
    }

    private static boolean isVisited(boolean[] visited) {
        for(int i = 1; i < visited.length; i++) {
            if(!visited[i])
                return false;
        }
        return true;
    }
}

class Edge implements Comparable<Edge>{
    int vertex;
    int weight;

    public Edge(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }

    public int compareTo(Edge e){
        return this.weight - e.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return vertex == edge.vertex && weight == edge.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex, weight);
    }
}