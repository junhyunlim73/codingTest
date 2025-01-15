import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dist;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j < N+1; j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k < N+1; k++){
            for(int i = 1; i < N+1; i++){
                for(int j = 1; j < N+1; j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(dist[a][b] <= c){
                sb.append("Enjoy other party").append("\n");
            }else{
                sb.append("Stay here").append("\n");
            }

        }

        System.out.println(sb);
        br.close();
    }

}