import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parents;
    static int[][] networks;
    static int V = 1;
    static int cnt;
    static long mst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        ArrayList<int[]> xy = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        networks = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) != find(b)){
                union(a,b);
                V++;
            }
        }

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N + 1; j++){
                int cost = Integer.parseInt(st.nextToken());

                if(j <= i)
                    continue;

                pq.add(new Edge(i, j, cost));
            }
        }

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int start = find(e.start);
            int end = find(e.end);

            if(start == 1)
                continue;

            if(start != end){
                union(start, end);
                V++;
                cnt++;
                mst += e.cost;
                xy.add(new int[]{e.start, e.end});
            }

            if(V == N - 1)
                break;
        }

        bw.write(mst + " " + cnt + "\n");

        for(int[] nums : xy){
            bw.write(nums[0] + " " + nums[1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int x){
        if(parents[x] == x) return x;
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