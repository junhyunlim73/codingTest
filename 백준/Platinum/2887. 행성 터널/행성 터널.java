import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static Point[] Xpoints;
    static Point[] Ypoints;
    static Point[] Zpoints;
    static int N, cnt;
    static long mst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        parents = new int[N];
        Xpoints = new Point[N];
        Ypoints = new Point[N];
        Zpoints = new Point[N];

        for(int i = 0; i < N; i++){
            parents[i] = i;
        }

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Xpoints[i] = new Point(i, x);
            Ypoints[i] = new Point(i, y);
            Zpoints[i] = new Point(i, z);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        Arrays.sort(Xpoints);
        Arrays.sort(Ypoints);
        Arrays.sort(Zpoints);

        for(int i = 1; i < N; i++){
            int weightX = Math.abs(Xpoints[i-1].weight - Xpoints[i].weight);
            int weightY = Math.abs(Ypoints[i-1].weight - Ypoints[i].weight);
            int weightZ = Math.abs(Zpoints[i-1].weight - Zpoints[i].weight);
            pq.add(new Edge(Xpoints[i-1].idx, Xpoints[i].idx, weightX));
            pq.add(new Edge(Ypoints[i-1].idx, Ypoints[i].idx, weightY));
            pq.add(new Edge(Zpoints[i-1].idx, Zpoints[i].idx, weightZ));
        }

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int start = find(e.start);
            int end = find(e.end);

            if(start != end){
                union(start, end);
                mst += e.weight;
                cnt++;
            }

            if(cnt == (N - 1))
                break;
        }

        System.out.println(mst);
        br.close();
    }

    private static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x < y)
            parents[y] = x;
        else
            parents[x] = y;
    }

    static class Point implements Comparable<Point>{
        int idx, weight;

        public Point(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        public int compareTo(Point o) {
            return Integer.compare(weight, o.weight);
        }
    }

    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }

    }

}