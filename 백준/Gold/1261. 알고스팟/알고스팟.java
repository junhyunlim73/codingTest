import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int N, M;
    static int[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[M][N];
        board = new int[M][N];

        for(int i = 0; i < M; i++){
            String[] temp = br.readLine().split("");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(temp[j]);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        q.add(new int[]{0, 0, 0});
        visited[0][0] = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int row = now[0];
            int col = now[1];
            int weight = now[2];

            if(row == M - 1 && col == N - 1){
                break;
            }

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr < 0 || nr >= M || nc < 0 || nc >= N)
                    continue;

                if(board[nr][nc] == 0 && weight < visited[nr][nc]){
                    visited[nr][nc] = weight;
                    q.add(new int[]{nr, nc, visited[nr][nc]});
                }else if(board[nr][nc] == 1 && weight + 1 < visited[nr][nc]){
                    visited[nr][nc] = weight + 1;
                    q.add(new int[]{nr, nc, visited[nr][nc]});
                }
            }

        }

        System.out.println(visited[M-1][N-1]);
        br.close();
    }

}