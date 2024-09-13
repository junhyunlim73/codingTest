import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] dist;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int INF = 1_000_000_000;
    static int total;
    static int num = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N == 0)
                break;

            dist = new int[N][N];
            arr = new int[N][N];

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            total = dijkstra(0,0);

            sb.append("Problem ").append(num).append(": ").append(total).append('\n');
            num++;
        }

        System.out.print(sb);
        br.close();
    }

    private static int dijkstra(int i, int j) {
        Queue<int []> q = new LinkedList<>();

        for (int k = 0; k < N; k++) {
            Arrays.fill(dist[k], INF);
        }

        dist[i][j] = arr[i][j];
        q.add(new int[] {i, j});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];

            for(int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;

                if(dist[nr][nc] == INF || dist[r][c] + arr[nr][nc] < dist[nr][nc]) {
                    dist[nr][nc] = dist[r][c] + arr[nr][nc];
                    q.add(new int[]{nr, nc});
                }

            }

        }

        return dist[N-1][N-1];
    }

}