import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][][] visited;
    static int K, W, H;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] dr2 = {-2, -1, 1, 2, 2, 1, -2, -1};
    static int[] dc2 = {1, 2, 2, 1, -1, -2, -1, -2};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][W];
        visited = new boolean[H][W][K+1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayDeque<Monkey> q = new ArrayDeque<>();
        q.add(new Monkey(0, 0, 0, K));
        visited[0][0][K] = true;

        while (!q.isEmpty()) {
            Monkey m = q.poll();
            int r = m.r;
            int c = m.c;
            int dist = m.dist;
            int jump = m.jump;

            if(r == H-1 && c == W-1){
                min = dist;
                break;
            }

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nc < 0 || nr >= H || nc >= W)
                    continue;

                if(visited[nr][nc][jump])
                    continue;

                if(board[nr][nc] == 0){
                    visited[nr][nc][jump] = true;
                    q.add(new Monkey(nr, nc, dist+1, jump));
                }
            }

            if(jump > 0){
                for (int i = 0; i < 8; i++){
                    int nr = r + dr2[i];
                    int nc = c + dc2[i];

                    if(nr < 0 || nc < 0 || nr >= H || nc >= W)
                        continue;

                    if(visited[nr][nc][jump-1])
                        continue;

                    if(board[nr][nc] == 0){
                        visited[nr][nc][jump-1] = true;
                        q.add(new Monkey(nr, nc, dist+1, jump-1));
                    }
                }
            }

        }

        System.out.println(min != Integer.MAX_VALUE ? min : -1);
        br.close();
    }

    static class Monkey{
        int r, c, dist, jump;

        public Monkey(int r, int c, int dist, int jump){
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.jump = jump;
        }

    }

}