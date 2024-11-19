import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static int N;
    static int farNode, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < N+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int v = Integer.parseInt(st.nextToken());

                if(v == -1)
                    break;

                int dist = Integer.parseInt(st.nextToken());
                adj[root].add(new Node(v, dist));
            }
        }

        dfs(1, 0);

        visited = new boolean[N+1];

        max = Integer.MIN_VALUE;
        dfs(farNode, 0);

        System.out.println(max);
        br.close();
    }

    private static void dfs(int start, int sum){
        if(visited[start]) return;

        visited[start] = true;

        if(max < sum){
            max = sum;
            farNode = start;
        }

        for(Node next : adj[start]){
            if(!visited[next.v]){
                dfs(next.v, sum + next.dist);
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