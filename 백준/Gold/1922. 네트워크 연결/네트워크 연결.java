import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int N, M;
    static long mst;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N + 1];

        for(int i = 1; i < N + 1; i++){
            parents[i] = i;
        }

        PriorityQueue<Edge> p = new PriorityQueue<>();

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            p.add(new Edge(a, b, c));
        }

        while(!p.isEmpty()){
            Edge e = p.poll();

            int startParents = find(e.start);
            int endParents = find(e.end);

            if(startParents != endParents){
                union(startParents, endParents);
                mst += e.cost;
                cnt++;
            }

            if(cnt == N - 1){
                break;
            }

        }

        System.out.println(mst);
        br.close();
    }

    private static int find(int x){
        if(parents[x] == x)
            return x;
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

    static class Edge implements Comparable<Edge> {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }

}