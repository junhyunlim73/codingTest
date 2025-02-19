import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, A, B, C;
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        visited[A] = true;
        dfs(A, B, 0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }

    private static void dfs(int s, int e, int dist, int maxCost){
        if(s == e){
            answer = Math.min(answer, maxCost);
            return;
        }

        for(Node next : adj[s]){
            int nextDist = dist + next.dist;

            if(!visited[next.v] && nextDist <= C){
                visited[next.v] = true;
                dfs(next.v, e, nextDist, Math.max(maxCost, next.dist));
                visited[next.v] = false;
            }
        }

    }

    static class Node{
        int v, dist;

        public Node(int v, int dist){
            this.v = v;
            this.dist = dist;
        }
        
    }

}