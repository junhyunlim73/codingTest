import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        StringBuilder sb = new StringBuilder();

        for(int i = 4; i < 12; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n] + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}