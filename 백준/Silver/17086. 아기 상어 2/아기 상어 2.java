import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] cnts;
    static boolean[][] visited;
    static int[] dr = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][M];
        cnts = new int[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 1) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int k = 0; k < 8; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc])
                    continue;

                if(arr[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    cnts[nr][nc] = cnts[cur[0]][cur[1]] + 1;
                    cnt = Math.max(cnt, cnts[nr][nc]);
                    q.add(new int[] {nr, nc});
                }
            }
        }

        System.out.println(cnt);
    }
}