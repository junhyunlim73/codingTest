import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static boolean[] men;
    static int N, M;
    static long mst;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        men = new boolean[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N + 1; i++){
            if(st.nextToken().equals("M"))
                men[i] = true;
            parents[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(men[u] != men[v]){
                pq.add(new Node(u, v, d));
            }
        }

        while(!pq.isEmpty()){
            Node node = pq.poll();

            int startRoot = find(node.start);
            int endRoot = find(node.end);

            if(startRoot != endRoot){
                union(startRoot, endRoot);
                mst += node.cost;
                cnt++;
            }

            if(cnt == N - 1)
                break;
        }

        System.out.println(cnt == N - 1 ? mst : -1);
    }

    private static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x < y)parents[y] = x;
        else parents[x] = y;
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Node n){
            return cost - n.cost;
        }
    }

}