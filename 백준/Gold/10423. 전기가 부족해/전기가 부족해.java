import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int N, M, K;
    static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    static int cnt;
    static int mst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];

        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++){
            int idx = Integer.parseInt(st.nextToken());
            parents[idx] = -1;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(u, v, w));
        }

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            int startParent = find(now.start);
            int endParent = find(now.end);

            if(startParent != endParent){
                union(startParent, endParent);
                mst += now.weight;
                cnt++;
            }

            if(cnt == N - 1)
                break;
        }

        System.out.println(mst);
        br.close();
    }

    private static int find(int x){
        if(x == -1)
            return -1;

        if(parents[x] == x)
            return x;

        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x == -1)
                parents[y] = -1;
            else if(y == -1)
                parents[x] = -1;
            else{
                parents[y] = x;
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }

}