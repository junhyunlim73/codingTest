import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int I  = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            for(int j = N; j >= 0; j--){
                if(T <= j)
                    dp[j] = Math.max(dp[j], dp[j-T] + I);
                else
                    break;
            }
        }

        System.out.println(dp[N]);
        br.close();
    }

}