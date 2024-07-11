import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N, M, K;
    static int[][] adj;
    static boolean[][] visited;
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            adj = new int[N][M];
            visited = new boolean[N][M];

            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                adj[X][Y] = 1;
            }

            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(adj[j][k] == 1 && !visited[j][k]){
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[]{j, k});
                        visited[j][k] = true;
                        cnt++;

                        while(!q.isEmpty()){
                            int[] now = q.poll();

                            for(int m = 0; m < 4; m++){
                                int nc = now[0] + dc[m];
                                int nr = now[1] + dr[m];

                                if(nc < 0 || nc >= N || nr < 0 || nr >= M || adj[nc][nr] == 0 || visited[nc][nr])
                                    continue;

                                q.add(new int[]{nc, nr});
                                visited[nc][nr] = true;
                            }
                        }
                    }
                }
            }
            
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}