import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int area = 1;
    static int max = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
            }
        }

        for(int i = 1; i < max + 1; i++){
            int cnt = 0;
            visited = new boolean[N][N];

            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(board[j][k] > i && !visited[j][k]){
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[]{j, k});
                        visited[j][k] = true;
                        cnt++;

                        while(!q.isEmpty()){
                            int[] now = q.poll();
                            int row = now[0];
                            int col = now[1];

                            for(int m = 0; m < 4; m++){
                                int nr = row + dr[m];
                                int nc = col + dc[m];

                                if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                                    continue;

                                if(board[nr][nc] > i && !visited[nr][nc]){
                                    visited[nr][nc] = true;
                                    q.add(new int[]{nr, nc});
                                }
                            }

                        }

                    }
                }
            }
            area = Math.max(area, cnt);
        }

        System.out.println(area);
        br.close();
    }

}