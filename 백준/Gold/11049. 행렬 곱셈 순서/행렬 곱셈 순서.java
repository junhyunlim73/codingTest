import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N][N];
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int k = 1; k < N; k++) {
            for (int i = 0; i + k < N; i++) {
                dp[i][i+k] = Integer.MAX_VALUE;
                for (int j = i; j < i + k; j++) {
                    dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j] + dp[j+1][i+k] + arr[i][0] * arr[j][1] * arr[i+k][1]);
                }
            }
        }

        System.out.println(dp[0][N-1]);
        br.close();
    }

}