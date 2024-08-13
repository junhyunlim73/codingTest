import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static ArrayList<Integer>[] adj;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            boolean isBipartite = true;

            graph = new int[V+1];
            adj = new ArrayList[V+1];

            for(int j = 1; j <= V; j++){
                adj[j] = new ArrayList<>();
            }

            for(int j = 0; j < E; j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                adj[v].add(u);
            }

            for(int j = 1; j <= V; j++){
                if(graph[j] == 0){
                    if(!bfsCheck(j)){
                        isBipartite = false;
                        break;
                    }
                }
            }

            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static boolean bfsCheck(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        graph[start] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int v : adj[cur]){
                if(graph[v] == 0){
                    graph[v] = 3 - graph[cur];
                    q.add(v);
                } else if(graph[v] == graph[cur]){
                    return false;  // 이분 그래프가 아님을 발견
                }
            }
        }
        return true;  // 이분 그래프임
    }
}
