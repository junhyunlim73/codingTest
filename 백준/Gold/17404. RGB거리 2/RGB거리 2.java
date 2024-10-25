import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] coin;
    static int[] paints;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][3];
        coin = new int[N+1][3];
        paints = new int[3];

        for(int i = 1; i < N + 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                coin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == j)
                    dp[1][j] = coin[1][j];
                else
                    dp[1][j] = 1000001;
            }

            for(int j = 2; j < N + 1; j++){
                dp[j][0] = Math.min(dp[j-1][2], dp[j-1][1]) + coin[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + coin[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + coin[j][2];

                if(j == N){
                    if(i == 0){
                        paints[i] = Math.min(dp[N][1], dp[N][2]);
                    }

                    if(i == 1){
                        paints[i] = Math.min(dp[N][0], dp[N][2]);
                    }

                    if(i == 2){
                        paints[i] = Math.min(dp[N][0], dp[N][1]);
                    }
                }

            }

        }

        System.out.println(Math.min(paints[0], Math.min(paints[1], paints[2])));
        br.close();
    }

}