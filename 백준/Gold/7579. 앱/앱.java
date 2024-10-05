import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static long[] dp;
    static int N, M;
    static int[][] arr;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][2];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
            total += arr[i][1];
        }

        dp = new long[total + 1];
        Arrays.fill(dp, 0);
        dp[0] = 0;

        for(int i = 1; i < N + 1; i++){
            int mb = arr[i][0];
            int cost = arr[i][1];
            for(int j = total; j >= cost; j--){
                dp[j] = Math.max(dp[j], dp[j-cost] + mb);
            }
        }

        for(int i = 0; i < total + 1; i++){
            if(dp[i] >= M){
                System.out.println(i);
                break;
            }
        }

        br.close();
    }

}