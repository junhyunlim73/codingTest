import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<XY> list = new ArrayList<XY>();
    static ArrayList<Edge>[] adj;
    static double[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        XY s = new XY(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

        st = new StringTokenizer(br.readLine());

        XY e = new XY(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

        int n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n+2];
        times = new double[n+2];

        for(int i = 0; i < n + 2; i++){
            adj[i] = new ArrayList<Edge>();
        }

        list.add(s);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            list.add(new XY(x, y));
        }

        list.add(e);

        for(int i = 1; i < n+2; i++){
            double dist = Math.sqrt(Math.pow(list.get(0).x - list.get(i).x, 2) + Math.pow(list.get(0).y - list.get(i).y, 2));
            adj[0].add(new Edge(i, dist / 5.0));
        }

        for(int i = 1; i < n + 2; i++){
            for(int j = 0; j < n + 2; j++){
                if(i == j)
                    continue;
                double dist = Math.sqrt(Math.pow(list.get(i).x - list.get(j).x, 2) + Math.pow(list.get(i).y - list.get(j).y, 2));
                adj[i].add(new Edge(j, Math.min(dist / 5.0, Math.abs(dist - 50) / 5.0) + 2));
            }
        }

        dijkstra(0);
        System.out.print(times[n+1]);
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(times, Double.MAX_VALUE);

        times[start] = 0;
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(times[e.v] < e.time)
                continue;

            for(Edge next : adj[e.v]){
                if(times[next.v] == Double.MAX_VALUE || times[e.v] + next.time < times[next.v]){
                    times[next.v] = times[e.v] + next.time;
                    pq.add(new Edge(next.v, times[next.v]));
                }
            }

        }

    }

    static class XY{
        double x, y;

        public XY(double x, double y){
            this.x = x;
            this.y = y;
        }

    }

    static class Edge implements Comparable<Edge>{
        int v;
        double time;

        public Edge(int v, double time){
            this.v = v;
            this.time = time;
        }

        public int compareTo(Edge o){
            return Double.compare(this.time, o.time);
        }

    }
}