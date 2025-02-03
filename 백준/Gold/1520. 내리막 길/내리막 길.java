import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        pq.add(new int[]{0, 0, board[0][0]});
        visited[0][0] = 1;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];

            if(board[r][c] <= board[N-1][M-1]){
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;

                if(board[nr][nc] >= board[r][c])
                    continue;

                if(visited[nr][nc] == 0){
                    pq.add(new int[]{nr, nc, board[nr][nc]});
                }

                visited[nr][nc] += visited[r][c];
            }

        }

        System.out.println(visited[N-1][M-1]);
        br.close();
    }

}