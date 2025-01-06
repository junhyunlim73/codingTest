import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int brige = Integer.MAX_VALUE;
    static int area = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && board[i][j] == 1) {
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    visited[i][j] = true;
                    q.add(new int[] {i, j});
                    area++;
                    board[i][j] = area;

                    while(!q.isEmpty()) {
                        int[] now = q.poll();

                        for(int k = 0; k < 4; k++) {
                            int nr = now[0] + dr[k];
                            int nc = now[1] + dc[k];

                            if(nr < 0 || nc < 0 || nr >= N || nc >= N)
                                continue;

                            if(visited[nr][nc])
                                continue;

                            if(board[nr][nc] == 1){
                                visited[nr][nc] = true;
                                board[nr][nc] = area;
                                q.add(new int[] {nr, nc});
                            }else if(board[nr][nc] == 0){
                                visited[nr][nc] = true;
                                queue.add(new int[] {nr, nc, area, 1});
                            }

                        }

                    }

                }
            }
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            dfs(now);
        }

        System.out.println(brige);
        br.close();
    }

    private static void dfs(int[] arr) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(arr);
        visited = new boolean[N][N];
        visited[arr[0]][arr[1]] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int id = now[2];
            int dist = now[3];

            if(brige <= dist)
                continue;

            for(int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N)
                    continue;

                if(!visited[nr][nc] && board[nr][nc] == 0){
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc, id, dist + 1});
                }else if(board[nr][nc] != 0 && board[nr][nc] != id){
                    brige = Math.min(brige, dist);
                }

            }

        }
    }

}