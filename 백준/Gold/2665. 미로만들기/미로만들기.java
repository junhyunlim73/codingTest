import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] board;
    static int[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(temp[j]);
            }
            Arrays.fill(visited[i], 2501);
        }

        visited[0][0] = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int d = now[2];

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;

                if(d < visited[nr][nc] && board[nr][nc] == 1){
                    visited[nr][nc] = d;
                    q.offer(new int[]{nr, nc, d});
                }else if((d + 1) < visited[nr][nc] && board[nr][nc] == 0){
                    visited[nr][nc] = d + 1;
                    q.offer(new int[]{nr, nc, d + 1});
                }
            }

        }

        System.out.println(visited[N - 1][N - 1]);
        br.close();
    }

}