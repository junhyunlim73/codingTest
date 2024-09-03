import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer>[] adj_re;
    static boolean[][] visited;
    static int cnt;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        adj_re = new ArrayList[N+1];
        visited = new boolean[N+1][N+1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
            adj_re[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[v].add(e);
            adj_re[e].add(v);
        }

        for(int i = 1; i <= N; i++){
            dfs(i, i);
            dfs_re(i, i);
        }

        for(int i = 1; i <= N; i++){
            boolean flag = false;
            for(int j = 1; j <= N; j++){
                if(!visited[i][j]){
                    flag = true;
                    break;
                }

            }

            if(!flag)
                cnt++;

        }

        System.out.println(cnt);
        br.close();
    }

    private static void dfs(int pre, int start){
        visited[pre][start] = true;

        for(int d : adj[start]){
            if(!visited[pre][d]){
                dfs(pre, d);
            }
        }

    }

    private static void dfs_re(int pre, int start){
        visited[pre][start] = true;

        for(int d : adj_re[start]){
            if(!visited[pre][d]){
                dfs_re(pre, d);
            }
        }

    }

}