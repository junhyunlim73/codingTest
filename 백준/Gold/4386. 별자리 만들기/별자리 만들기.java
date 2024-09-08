import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static double mst;
    static ArrayList<Edge>[] adj;
    static ArrayList<double[]> xy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        adj = new ArrayList[N];
        xy = new ArrayList<>();

        for(int i = 0; i < N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            xy.add(new double[]{x, y});
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                double[] xy1 = xy.get(i);
                double[] xy2 = xy.get(j);
                double weight = CalculateXY(xy1, xy2);
                pq.add(new Edge(i, weight));
                adj[i].add(new Edge(j, weight));
                adj[j].add(new Edge(i, weight));
            }
        }

        int start = pq.poll().vertex;

        prim(start);
        System.out.println(String.format("%.2f", mst));
        br.close();
    }

    private static double CalculateXY(double[] xy1, double[] xy2){
        double x1 = xy1[0];
        double y1 = xy1[1];
        double x2 = xy2[0];
        double y2 = xy2[1];
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static void prim(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(visited[e.vertex])
                continue;

            visited[e.vertex] = true;
            mst += e.weight;

            for(Edge next : adj[e.vertex]){
                if(!visited[next.vertex]){
                    pq.add(next);
                }
            }

        }

    }

    static class Edge implements Comparable<Edge>{
        int vertex ;
        double weight;

        public Edge(int vertex, double weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        public int compareTo(Edge e){
            return Double.compare(this.weight, e.weight);
        }
    }

}