import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] T;
    static int[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+2];
        T = new int[N+2];
        P = new int[N+2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 1; i <= N+1; i++) {
            if(max < dp[i])
                max = dp[i];

            if((i+T[i]) < N + 2){
                dp[i+T[i]] = Math.max(max + P[i], dp[i+T[i]]);
            }
            
        }

        System.out.println(max);
        br.close();
    }

}