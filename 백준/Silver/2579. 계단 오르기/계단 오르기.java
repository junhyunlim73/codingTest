import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;

    public static void main(String[] args) throws IOException {
        dp = new int[301];
        int[] stair = new int[301];
        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stair[1];
        dp[2] = Math.max(stair[2], stair[1] + stair[2]);
        dp[3] = Math.max(stair[3] + stair[2], dp[1] + stair[3]);
        
        for(int i = 4; i <= N; i++){
            dp[i] = Math.max(dp[i-3] + stair[i-1], dp[i - 2]) + stair[i];
        }

        System.out.println(dp[N]);
        br.close();
    }
}