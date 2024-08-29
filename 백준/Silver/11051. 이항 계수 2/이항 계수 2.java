import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[1001][1001];

        System.out.println(combi(N, K));
        br.close();
    }

    private static int combi(int n, int k){
        if(dp[n][k] > 0)
            return dp[n][k];

        if(k == 0 || n == k)
            return dp[n][k] = 1;

        return dp[n][k] = (combi(n - 1, k) + combi(n-1, k-1)) % 10007;
    }

}