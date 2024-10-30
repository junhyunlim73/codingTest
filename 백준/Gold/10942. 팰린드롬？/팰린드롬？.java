import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[] arr;
    static int N, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        T = Integer.parseInt(br.readLine());

        for(int i = 1; i < N + 1; i++){
            for(int j = i; j < N + 1; j++){
                if(i == j){
                    dp[i][j] = 1;
                    continue;
                }

                if(isPalindrome(i - 1, j - 1)){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = 0;
                }

            }

        }

        while(T --> 0){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bw.write(dp[r][c] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPalindrome(int start, int end) {
        int cnt = (end - start)/2;

        for(int i = 0; i <= cnt; i++){
            if(arr[start+i] != arr[end-i]){
                return false;
            }
        }

        return true;
    }

}