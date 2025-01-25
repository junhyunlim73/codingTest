import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[1000001];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[N+1];

        if(N >= 2)
            dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = (i-1) * (dp[i-1] + dp[i-2]) % 1000000000;
        }
        
        System.out.println(dp[N]);
        br.close();
    }

}