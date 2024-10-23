import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    static int N, M, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);
        Q = Integer.parseInt(br.readLine());

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            long result = kruscal(edges, x, y);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int x) {
        if(x == -1)
            return -1;

        if(parents[x] == 0)
            return x;

        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y){
            if(x == -1)
                parents[y] = x;
            else if(y == -1)
                parents[x] = y;
            else
                parents[y] = x;
        }

    }

    private static long kruscal(ArrayList<Edge> edges, int x, int y) {
        parents = new int[N + 1];
        long mst = 0;
        int cnt = 0;

        parents[x] = -1;
        parents[y] = -1;

        for(Edge e : edges) {
            int start = find(e.start);
            int end = find(e.end);

            if(start != end){
                union(start, end);
                mst += e.cost;
                cnt++;
            }

            if(cnt == N - 2)
                break;
        }

        return mst;
    }

    static class Edge implements Comparable<Edge>{
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}