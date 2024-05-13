import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] box;
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        int cnt = 0;
        int max = 1;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    queue.add(new int[]{i, j});
                }else if(box[i][j] == 0){
                    cnt++;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int c = now[0];
            int r = now[1];

            for(int i = 0 ; i < 4; i++){
                int nc = c + dc[i];
                int nr = r + dr[i];

                if(nc >= 0 && nr >= 0 && nc < N && nr < M && box[nc][nr] == 0){
                    box[nc][nr] = box[c][r] + 1;
                    cnt--;
                    max = Math.max(box[nc][nr], max);
                    queue.add(new int[]{nc, nr});
                }

            }
        }

        System.out.println(cnt == 0 ? max - 1 : -1);
        br.close();
    }
}