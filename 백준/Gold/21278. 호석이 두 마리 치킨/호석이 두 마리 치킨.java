import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dist;
    static int INF = 1_000_000;
    static int s = 101, e = 101;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 2;
            dist[b][a] = 2;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = i + 1; j <= N; j++){
                int sum = 0;

                for(int k = 1; k <= N; k++){
                    sum += Math.min(dist[i][k], dist[j][k]);
                }

                if(sum < min){
                    min = sum;
                    s = i;
                    e = j;
                }
            }

        }

        sb.append(s).append(" ").append(e).append(" ").append(min).append("\n");
        System.out.print(sb);
        br.close();
    }

}