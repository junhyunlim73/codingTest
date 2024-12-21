import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int N, M;
    static int cnt;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;

            if(flag){
                System.out.println(1);
                return;
            }

        }

        System.out.println(0);
        br.close();
    }

    private static void dfs(int i, int depth) {
        if(depth == 4){
            flag = true;
            return;
        }

        for(int next : adj[i]){
            if(!visited[next]){
                visited[next] = true;
                dfs(next, depth+1);
                visited[next] = false;
            }
        }

    }

}