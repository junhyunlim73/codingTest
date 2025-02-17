import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dist;
    static int[][] nodes;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];
        nodes = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = c;
            dist[b][a] = c;
            nodes[a][b] = b;
            nodes[b][a] = a;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(i == k)
                        continue;

                    if(dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        nodes[i][j] = nodes[i][k];
                    }

                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(nodes[i][j] == 0) {
                    sb.append("- ");
                }else
                    sb.append(nodes[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}