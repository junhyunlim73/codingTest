import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static XY[] xyArr;
    static ArrayList<Edge>[] adj;
    static double[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        XY s = new XY(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

        st = new StringTokenizer(br.readLine());

        XY e = new XY(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

        int n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n+2];
        xyArr = new XY[n+2];
        times = new double[n+2];

        for(int i = 0; i < n + 2; i++){
            adj[i] = new ArrayList<Edge>();
        }

        xyArr[0] = s;
        xyArr[n+1] = e;

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            xyArr[i] = new XY(x, y);
        }

        for(int i = 1; i < n+2; i++){
            double dist = Math.sqrt(Math.pow(xyArr[0].x - xyArr[i].x, 2) + Math.pow(xyArr[0].y - xyArr[i].y, 2));
            adj[0].add(new Edge(i, dist / 5.0));
        }

        for(int i = 1; i < n + 2; i++){
            for(int j = i + 1; j < n + 2; j++){
                double dist = Math.sqrt(Math.pow(xyArr[i].x - xyArr[j].x, 2) + Math.pow(xyArr[i].y - xyArr[j].y, 2));
                double time = Math.min(dist / 5.0, Math.abs(dist - 50) / 5.0 + 2);
                adj[i].add(new Edge(j, time));
                adj[j].add(new Edge(i, time));
            }
        }

        dijkstra(0);
        System.out.println(times[n+1]);
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