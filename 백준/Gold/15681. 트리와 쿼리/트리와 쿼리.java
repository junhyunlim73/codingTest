import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adj;
    static int[] dp;
    static int N, R, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        dp = new int[N+1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(R);

        for(int i = 0; i < Q; i++){
            int q = Integer.parseInt(br.readLine());
            sb.append(dp[q]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static int dfs(int start){
        if(dp[start] != 0)
            return dp[start];

        dp[start] = 1;

        for(int d : adj[start]){
            if(dp[d] == 0){
                dp[start] += dfs(d);
            }
        }

        return dp[start];
    }

}