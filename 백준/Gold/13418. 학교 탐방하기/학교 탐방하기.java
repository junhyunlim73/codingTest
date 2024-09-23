import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] adj;
    static int N, M;
    static boolean[] visited;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M + 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        PriorityQueue<Node> pq1 = new PriorityQueue<>((o1, o2) -> (Integer.compare(o2.w, o1.w)));
        PriorityQueue<Node> pq2 = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1.w, o2.w)));

        min = N - prim(0, pq1);
        max = N - prim(0, pq2);

        int result = (max * max) - (min * min);
        System.out.println(result);
        br.close();
    }

    private static int prim(int start, PriorityQueue<Node> pq){
        int result = 0;
        pq.add(new Node(start, 0));
        visited = new boolean[N + 1];

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.v])
                continue;

            visited[now.v] = true;
            result += now.w;

            for(Node next : adj[now.v]){
                if(!visited[next.v]){
                    pq.add(next);
                }
            }

        }

        return result;
    }

    static class Node{
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

}