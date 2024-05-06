import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static int[][] box;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        int day = 1;
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }else if(box[i][j] == 0) {
                    cnt++;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i = 0; i < 4; i++){
                int c = now[0] + dc[i];
                int r = now[1] + dr[i];

                if(c >= 0 && r >= 0 && r < M  && c < N && box[c][r] == 0){
                    queue.add(new int[] {c, r});
                    box[c][r] = box[now[0]][now[1]] + 1;
                    day = Math.max(box[c][r], day);
                    cnt--;
                }

            }
        }
        
        System.out.println(cnt == 0 ? day - 1 : -1);
        br.close();
    }

}