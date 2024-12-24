import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k, s;
    static boolean[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dist = new boolean[n+1][n+1];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = true;
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(dist[i][k] && dist[k][j]){
                        dist[i][j] = true;
                    }
                }
            }
        }

        s = Integer.parseInt(br.readLine());

        for(int i = 0; i < s; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(dist[a][b]){
                sb.append(-1).append("\n");
            }else if(dist[b][a]){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }

        }

        System.out.print(sb);
        br.close();
    }

}