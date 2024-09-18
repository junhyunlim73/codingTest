import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int T;
    static long mst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            boolean flag = false;
            int cnt = 0;
            PriorityQueue<Node> pq = new PriorityQueue<Node>();

            parents = new int[N+1];

            for(int i = 1; i < N + 1; i++){
                parents[i] = i;
            }

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                pq.add(new Node(a, b, c));
            }

            while(!pq.isEmpty()){
                Node now = pq.poll();
                int start = find(now.start);
                int end = find(now.end);


                if((now.start == p && now.end == q) || (now.start == q && now.end == p)){
                    flag = true;
                }

                if(start != end){
                    union(start, end);
                    cnt++;
                    mst += now.w;
                }

                if(cnt == N - 1)
                    break;
            }

            sb.append(flag  && (cnt == N-1)? "YES" : "NO").append("\n");
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

    static class Node implements Comparable<Node>{
        int start, end, w;

        public Node(int start, int end, int w){
            this.start = start;
            this.end = end;
            this.w = w;
        }

        public int compareTo(Node n){
            return w - n.w;
        }
    }

}