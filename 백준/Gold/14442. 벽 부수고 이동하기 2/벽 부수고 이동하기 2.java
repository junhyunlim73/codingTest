import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M, K;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new int[K+1][N][M];

        for (int i = 0; i < N; i++) {
            String nums = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(nums.charAt(j) + "");
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, K});
        visited[K][0][0] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int crash = now[2];

            if(r == N - 1 && c == M - 1){
                ans = visited[crash][r][c];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;

                if(board[nr][nc] == 0 && visited[crash][nr][nc] == 0){
                    visited[crash][nr][nc] = visited[crash][r][c] + 1;
                    q.add(new int[]{nr, nc, crash});
                }else if(board[nr][nc] == 1 && crash > 0 && visited[crash-1][nr][nc] == 0){
                    visited[crash-1][nr][nc] = visited[crash][r][c] + 1;
                    q.add(new int[]{nr, nc, crash - 1});
                }

            }

        }

        System.out.println(ans);
        br.close();
    }
}