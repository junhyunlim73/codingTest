import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][N];
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            dp[N-1][i] = arr[N-1][i];
        }

        System.out.println(down(0, 0));
    }

    private static int down(int i, int j){
        if(i == N-1){
            return dp[N-1][j];
        }

        if(dp[i][j] == 0){
            dp[i][j] = Math.max(down(i+1, j), down(i+1, j+1)) + arr[i][j];
        }

        return dp[i][j];
    }
}