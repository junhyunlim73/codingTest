import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dp = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        if(board[0][0] <= board[N-1][M-1])
            System.out.println(0);
        else
            System.out.println(dfs(0,0));

        br.close();
    }

    private static int dfs(int i, int j){
        if(i == N - 1 && j == M - 1)
            return 1;

        if(dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = 0;

        for(int k = 0; k < 4; k++){
            int nr = i + dr[k];
            int nc = j + dc[k];

            if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                continue;

            if(board[nr][nc] < board[i][j])
                dp[i][j] += dfs(nr, nc);

        }

        return dp[i][j];
    }

}