import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        dp = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N + 1; i++){
            dp[i][i] = 1;
        }

        for(int i = 1; i < N; i++){
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = 1;
            }
        }

        for(int i = 2; i < N; i++){
            for(int j = 1; j <= N - i; j++){
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1] == 1){
                    dp[j][j+i] = 1;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(dp[s][e] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}