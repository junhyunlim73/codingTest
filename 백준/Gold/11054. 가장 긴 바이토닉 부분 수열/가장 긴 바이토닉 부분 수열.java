import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] s;
    static int[] dp;
    static int[] dp2;
    static int N;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        s = new int[N];
        dp = new int[N];
        dp2 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);
        Arrays.fill(dp2, 1);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++){
                if(s[i] > s[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for(int i = N - 1; i >= 0; i--){
            for(int j = N - 1; j > i; j--){
                if(s[i] > s[j]){
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[i] + dp2[i]);
        }

        System.out.println(max - 1);
    }
}