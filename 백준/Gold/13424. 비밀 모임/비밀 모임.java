import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M, K;
    static int[][] dist;
    static int[] arr;
    static int INF = 1_000_000_000;
    static int min, idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dist = new int[N+1][N+1];
            min = Integer.MAX_VALUE;
            idx = 101;

            for (int i = 1; i < N+1; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                dist[a][b] = c;
                dist[b][a] = c;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }

            K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            arr = new int[K];

            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i < N + 1; i++){
                int total = 0;

                for(int n : arr){
                    total += dist[i][n];
                }

                if(total < min){
                    min = total;
                    idx = i;
                }else if(total == min){
                    idx = Math.min(idx, i);
                }

            }

            sb.append(idx).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}