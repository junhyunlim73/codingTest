import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] adj;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    static int area = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                adj[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, adj[i][j]);
            }
        }

        for(int i = 0; i <= max; i++){
            int cnt = 0;
            visited = new boolean[N][N];

            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(adj[j][k] > i && !visited[j][k]){
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[]{j, k});
                        cnt++;
                        visited[j][k] = true;

                        while(!q.isEmpty()){
                           int[] now = q.poll();

                           for(int m = 0; m < 4; m++){
                               int nr = now[0] + dr[m];
                               int nc = now[1] + dc[m];

                               if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || adj[nr][nc] <= i)
                                   continue;

                               q.add(new int[]{nr, nc});
                               visited[nr][nc] = true;
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