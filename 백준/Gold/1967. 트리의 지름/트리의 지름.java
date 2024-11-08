import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static int max = 0;
    static int maxIdx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];

        for(int i = 1; i < N+1; i++){
            adj[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj[parent].add(new Node(child, weight));
            adj[child].add(new Node(parent, weight));
        }

        visited = new boolean[N+1];
        dfs(1, 0);

        visited = new boolean[N+1];
        dfs(maxIdx, 0);

        System.out.println(max);
        br.close();
    }

    private static void dfs(int start, int dist){
        if(visited[start]) return;

        visited[start] = true;

        if(max < dist){
            max = dist;
            maxIdx = start;
        }

        for(Node n : adj[start]){
            if(!visited[n.idx]){
                dfs(n.idx, dist+n.weight);
            }
        }

    }

    static class Node{
        int idx, weight;

        public Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }

    }
}