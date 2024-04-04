import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] deep;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        deep = new int[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
            deep[i] = -1;
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for(int i = 1; i < n+1; i++){
            Collections.sort(graph[i], Collections.reverseOrder());
        }
        deep[r] = 0;
        DFS(r, 1);
        for(int i = 1; i <= n; i++){
            System.out.println(deep[i]);
        }
        br.close();
    }

    private static void DFS(int r, int num){
        visited[r] = true;
        for(int i : graph[r]){
            if(!visited[i]){
                deep[i] = num;
                DFS(i, num+1);
            }
        }
    }
}