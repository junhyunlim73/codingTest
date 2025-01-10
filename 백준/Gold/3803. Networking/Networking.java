import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int P, R;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            cnt = 0;
            int mst = 0;

            if(P == 0)
                break;

            R = Integer.parseInt(st.nextToken());

            parents = new int[P+1];

            for (int i = 1; i <= P; i++){
                parents[i] = i;
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();

            for(int i = 0; i < R; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                pq.add(new Edge(start, end, weight));
            }

            while(!pq.isEmpty()){
                Edge e = pq.poll();
                int start = find(e.start);
                int end = find(e.end);

                if(start != end){
                    union(start, end);
                    cnt++;
                    mst += e.weight;
                }

                if(cnt == (P-1))
                    break;
            }

            sb.append(mst).append("\n");
            br.readLine();
        }

        System.out.print(sb);
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

    static class Edge implements Comparable<Edge>{
        int start, end, weight;

        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Edge o){
            return Integer.compare(weight, o.weight);
        }
    }

}