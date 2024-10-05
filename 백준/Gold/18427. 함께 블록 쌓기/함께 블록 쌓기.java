import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static int N, M, H;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        dp = new int[N+1][H+1];

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new ArrayList<>();

            while(st.hasMoreTokens()){
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < N + 1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < N + 1; i++){
            for(int j = H; j >= 1; j--){
                for(int block : arr[i]){
                    if(j >= block){
                        dp[i][j] = (dp[i][j] + dp[i-1][j-block]) % 10007;
                    }
                }
                dp[i][j] = (dp[i][j] + dp[i-1][j]) % 10007;
            }
        }

        System.out.println(dp[N][H]);
        br.close();
    }

}