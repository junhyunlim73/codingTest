import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int T, K;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp = new int[K + 1][K + 1];
            prefixSum = new int[K + 1];

            for(int i = 1; i <= K; i++) {
                prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i < K; i++){
                for(int start = 1; start + i <= K; start++) {
                    int end = start + i;

                    dp[start][end] = Integer.MAX_VALUE;

                    for(int j = start; j < end; j++){
                        dp[start][end] = Math.min(dp[start][end], dp[start][j] + dp[j+1][end]);
                    }

                    dp[start][end] += prefixSum[end] - prefixSum[start-1];
                }
            }

            sb.append(dp[1][K]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}