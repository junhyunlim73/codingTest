import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] board;
    static int start = Integer.MAX_VALUE, end;
    static int D = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = N - 1; i >= 0; i--) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                start = Math.min(start, board[i][j]);
                end = Math.max(end, board[i][j]);
            }
        }

        while(start <= end) {
            int mid = (start + end) / 2;

            if(bfs(mid) < K){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(start);
        br.close();
    }

    private static int bfs(int mid){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            if(board[i][0] <= mid){
                q.add(new int[]{i, 0});
                visited[i][0] = true;
            }

            if(board[i][M - 1] <= mid){
                q.add(new int[]{i, M - 1});
                visited[i][M - 1] = true;
            }
        }

        for(int i = 1; i < M - 1; i++) {
            if(board[N-1][i] <= mid){
                q.add(new int[]{N-1, i});
                visited[N-1][i] = true;
            }
        }

        int cnt = q.size();

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;

                if(!visited[nr][nc] && board[nr][nc] <= mid){
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    cnt++;
                }

            }

        }

        return cnt;
    }

}