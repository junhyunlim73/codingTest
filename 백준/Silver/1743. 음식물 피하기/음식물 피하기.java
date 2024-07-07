import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dc = {-1, 1, 0, 0 };
    static int[] dr = {0, 0, -1, 1 };
    static int[][] adj;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        adj = new int[n][m];
        int trash = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[r-1][c-1] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(adj[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int cnt = 0;

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        cnt++;

                        int r = cur[0];
                        int c = cur[1];

                        for(int k = 0; k < 4; k++){
                            int nr = r + dr[k];
                            int nc = c + dc[k];

                            if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || adj[nr][nc] == 0)
                                continue;

                            q.add(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                    trash = Math.max(cnt, trash);
                }
            }
        }
        System.out.println(trash);
        br.close();
    }
}