import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] board;
    static int N, M;
    static int r, c, d, cnt;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(!flag){
            if(board[r][c] == 0){
                cnt++;
                board[r][c] = 2;
            }

            if(isClean(r, c)){
                int nd = (d + 2) % 4;
                int nr = r + dr[nd];
                int nc = c + dc[nd];

                if(board[nr][nc] == 1){
                    flag = true;
                }else{
                    r = nr;
                    c = nc;
                }
                continue;
            }else{
                d = (d + 3) % 4;

                int nr = r + dr[d];
                int nc = c + dc[d];

                if(board[nr][nc] == 0){
                    r = nr;
                    c = nc;
                }
            }

        }

        System.out.println(cnt);
        br.close();
    }

    private static boolean isClean(int r, int c){
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                if(board[nr][nc] == 0){
                    return false;
                }
            }

        }

        return true;
    }

}