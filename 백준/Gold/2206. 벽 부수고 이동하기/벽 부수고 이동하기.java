import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] adj;
    static boolean[][][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = -1;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            char[] nums = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                adj[i][j] = Integer.parseInt(String.valueOf(nums[j]));
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1, true));
        visited[0][0][1] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int dist = p.dist;
            boolean crash = p.crash;

            if(r == N - 1 && c == M - 1){
                answer = dist;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc][crash ? 1 : 0]) continue;

                if(adj[nr][nc] == 0) {
                    q.add(new Pair(nr, nc, dist + 1, crash));
                    visited[nr][nc][crash ? 1 : 0] = true;
                }else if(adj[nr][nc] == 1 && crash){
                    q.add(new Pair(nr, nc, dist + 1, false));
                    visited[nr][nc][0] = true;
                }
            }
        }

        System.out.println(answer);
    }

}

class Pair {
    int r, c;
    int dist;
    boolean crash;

    public Pair(int r, int c, int dist, boolean crash) {
        this.r = r;
        this.c = c;
        this.dist = dist;
        this.crash = crash;
    }
}