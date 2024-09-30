import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = line[j];
            }
        }

        dfs(0, 0, 1, String.valueOf(board[0][0]));

        System.out.println(max);
        br.close();
    }

    private static void dfs(int i, int j, int depth, String str){
        for(int k = 0; k < 4; k++){
            int nr = i + dr[k];
            int nc = j + dc[k];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                continue;

            if(!str.contains(board[nr][nc]+"")){
                dfs(nr, nc, depth + 1, str + board[nr][nc]);
            }else{
                max = Math.max(max, depth);
            }
        }
    }

}