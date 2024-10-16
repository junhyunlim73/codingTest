import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            for(int j = c1; j < c2; j++) {
                for(int k = r1; k < r2; k++) {
                    visited[j][k] = true;
                }
            }

        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    pq.add(bfs(i, j));
                }
            }
        }

        bw.write(pq.size() + "\n");

        while(!pq.isEmpty()) {
            bw.write(pq.poll() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int i, int j) {
        int area = 1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.add(new int[] {i, j});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;

                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                    area++;
                }

            }
        }

        return area;
    }

}