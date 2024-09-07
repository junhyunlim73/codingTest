import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static double mst;
    static PriorityQueue<Node> pq;
    static ArrayList<int[]> xy;
    static int[] parents;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        xy = new ArrayList<>();
        pq = new PriorityQueue<>();

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xy.add(new int[]{x, y});
            parents[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(find(start) != find(end)){
                union(start, end);
                cnt++;
            }
        }

        for(int i = 1; i < N + 1; i++){
            for(int j = i + 1; j < N + 1; j++){
                int[] xy1 = xy.get(i - 1);
                int[] xy2 = xy.get(j - 1);
                int x = Math.abs(xy1[0] - xy2[0]);
                int y = Math.abs(xy1[1] - xy2[1]);
                double weight = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                pq.offer(new Node(i, j, weight));
            }
        }

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int start = find(node.start);
            int end = find(node.end);

            if(start != end){
                union(start, end);
                mst += node.weight;
                cnt++;
            }

            if(cnt == N - 1)
                break;
        }

        System.out.println(String.format("%.2f", mst));
        br.close();
    }

    private static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x < y) parents[y] = x;
        else parents[x] = y;
    }

    static class Node implements Comparable<Node>{
        int start, end;
        double weight;

        public Node(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return Double.compare(this.weight, o.weight);
        }

    }

}