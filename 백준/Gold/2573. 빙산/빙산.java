import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int N, M;
    static int cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean flag = false;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] != 0)
                    cnt++;
            }
        }

        if(bfs() > 1){
            System.out.println(0);
            return;
        }

        while(!flag && cnt > 0){
            int[][] temp = new int[N][M];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    temp[i][j] = board[i][j];
                }
            }

            for(int i = 1; i < N-1; i++){
                for(int j = 1; j < M-1; j++){
                    if(board[i][j] != 0){
                        for(int k = 0; k < 4; k++){
                            int nr = i + dr[k];
                            int nc = j + dc[k];

                            if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                                continue;

                            if(board[nr][nc] == 0){
                                temp[i][j]--;
                            }

                            if(temp[i][j] == 0){
                                cnt--;
                                break;
                            }

                        }
                    }
                }

            }

            board = temp;

            if(bfs() > 1){
                flag = true;
            }

            time++;


        }

        if(flag)
            System.out.println(time);
        else
            System.out.println(0);

        br.close();
    }

    private static int bfs(){
        visited = new boolean[N][M];
        int area = 0;

        for(int i = 1; i < N-1; i++){
            for(int j = 1; j < M-1; j++){
                if(!visited[i][j] && board[i][j] != 0){
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        int[] now = q.poll();

                        for(int k = 0; k < 4; k++){
                            int nr = now[0] + dr[k];
                            int nc = now[1] + dc[k];

                            if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                                continue;

                            if(!visited[nr][nc] && board[nr][nc] != 0){
                                visited[nr][nc] = true;
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }

                    area++;
                }
            }
        }

        return area;
    }

}