import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        for(int i = 1; i <= Math.sqrt(N); i++) {
            dp[i*i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (dp[i] == 0) {
                dp[i] = Integer.MAX_VALUE; // 초기값 설정
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }

        System.out.println(dp[N]);
        br.close();
    }

}