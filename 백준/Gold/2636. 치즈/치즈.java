import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int time, cnt, cheese;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 1)
                    cheese++;
            }
        }

        while (cheese > 0) {
            ArrayList<int[]> cheeses = bfs(0, 0);

            time++;
            cnt = cheese;

            for(int[] cur : cheeses){
                board[cur[0]][cur[1]] = 0;
                cheese--;
            }

        }

        sb.append(time).append("\n").append(cnt);
        System.out.println(sb);
        br.close();
    }

    private static ArrayList<int[]> bfs(int i, int j){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        ArrayList<int[]> cheeses = new ArrayList<>();
        q.add(new int[]{i, j});
        visited = new boolean[N][M];
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int k = 0; k < 4; k++){
                int nr = cur[0] + dr[k], nc = cur[1] + dc[k];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if(visited[nr][nc])
                    continue;

                if(board[nr][nc] == 0){
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }else if(board[nr][nc] == 1){
                    cheeses.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }

            }

        }

        return cheeses;
    }

}