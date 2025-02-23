import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int T, K, M, P;
    static int[] inDegree;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            int[] dp = new int[M + 1];
            int[] cnt = new int[M + 1];

            inDegree = new int[M + 1];
            adj = new ArrayList[M + 1];

            for(int i = 1; i < M + 1; i++){
                adj[i] = new ArrayList<>();
            }

            for(int i = 0; i < P; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                inDegree[b]++;
            }

            ArrayDeque<Integer> q = new ArrayDeque<>();

            for(int i = 1; i < M + 1; i++){
                if(inDegree[i] == 0){
                    q.add(i);
                    cnt[i] = 1;
                    dp[i] = 1;
                }
            }

            int max = 0;

            while(!q.isEmpty()){
                int now = q.poll();

                if(cnt[now] >= 2)
                    dp[now]++;

                max = Math.max(max, dp[now]);

                for(int d : adj[now]){
                    if(--inDegree[d] == 0){
                        q.add(d);
                    }

                    if(dp[now] == dp[d]){
                        cnt[d]++;
                    }else if(dp[d] < dp[now]){
                        cnt[d] = 1;
                        dp[d] = dp[now];
                    }

                }

            }

            sb.append(K).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}