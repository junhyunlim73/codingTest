import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parents;
    static long mst;
    static int cnt;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        arr = new int[3][2];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        for (int i = 0; i < 3; i++) {
            map.put(Integer.parseInt(st.nextToken()), i);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            int pre = map.get(road);
            pq.add(new Edge(start, end, cost, road, pre));
        }

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int start = find(e.start);
            int end = find(e.end);
            int cost = e.cost;
            int road = e.road;

            if(start != end){
                union(start, end);
                cnt++;
                mst += cost;
                arr[road][0]++;
                arr[road][1] += cost;
            }

            if(cnt == (N - 1))
                break;
        }

        System.out.println(mst);

        for(int i = 0; i < 3; i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

        br.close();
    }

    private static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b)
            parents[b] = a;
        else
            parents[a] = b;
    }


    static class Edge implements Comparable<Edge>{
        int start, end, cost, road, pre;

        public Edge(int start, int end, int cost, int road, int pre){
            this.start = start;
            this.end = end;
            this.cost = cost;
            this.road = road;
            this.pre = pre;
        }

        public int compareTo(Edge o){
            if(this.cost == o.cost){
                return Integer.compare(this.pre, o.pre);
            }
            return Integer.compare(this.cost, o.cost);
        }

    }

}