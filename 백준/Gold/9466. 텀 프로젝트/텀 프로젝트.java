import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, T;
    static int[] adj;
    static boolean[] visited;
    static boolean[] marked;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            adj = new int[N+1];
            visited = new boolean[N+1];
            marked = new boolean[N+1];
            cnt = N;

            for(int j = 1; j < N + 1; j++){
                adj[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j < N + 1; j++){
                if(!visited[j])
                    dfs(j);
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static void dfs(int start){
        visited[start] = true;
        int next = adj[start];

        if(!visited[next]){
            dfs(next);
        }else if(!marked[next]){
            for(int i = next; i != start; i = adj[i])
                cnt--;
            cnt--;

        }

        marked[start] = true;
    }

}