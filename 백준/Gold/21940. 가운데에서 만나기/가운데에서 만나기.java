import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[][] dist;
    static int N, M, K;
    static int INF = 1_000_000_000;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            dist[s][e] = d;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1 ; i <= N; i++){
                for(int j = 1 ; j <= N; j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        K = Integer.parseInt(br.readLine());

        int[] friends = new int[K];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++){
            friends[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            int max = 0;

            for(int friend : friends){
                int d = dist[friend][i] + dist[i][friend];
                max = Math.max(max, d);
            }

            if(max < min){
                min = max;
                list.clear();
                list.add(i);
            }else if(max == min){
                list.add(i);
            }

        }

        Collections.sort(list);

        for(int friend : list){
            sb.append(friend).append(" ");
        }
        System.out.println(sb);
        
        br.close();
    }

}