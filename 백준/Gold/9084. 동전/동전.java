import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] coins;
    static int T, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            coins = new int[N];

            for(int i = 0; i < N; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());
            dp = new int[M + 1];
            dp[0] = 1;

            for(int i = 0; i < N; i++){
                int coin = coins[i];
                for(int j = 1; j < M + 1; j++){
                    if(j - coin >= 0){
                        dp[j] += dp[j - coin];
                    }
                }
            }

            bw.write(dp[M] + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

}