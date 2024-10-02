import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] items;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];
        items = new int[N+1][2];

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N + 1; i++){
            int w = items[i][0];

            for(int j = 1; j < K + 1; j++){
                if(j < w)
                    dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - w] + items[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);
        br.close();
    }

}