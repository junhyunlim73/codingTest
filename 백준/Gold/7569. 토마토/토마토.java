import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[][][] boxes;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        boxes = new int[H][M][N];

        int cnt = 0;
        int max = 1;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());
                    if(boxes[i][j][k] == 0) {
                        cnt++;
                    }else if(boxes[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int h = now[0];
            int c = now[1];
            int r = now[2];

            for(int i = 0; i < 6; i++){
                int nh = h + dh[i];
                int nc = c + dc[i];
                int nr = r + dr[i];

                if(nh >= 0 && nc >= 0 && nr >= 0 && nh < H  && nc < M && nr < N && boxes[nh][nc][nr] == 0) {
                    queue.add(new int[]{nh, nc, nr});
                    boxes[nh][nc][nr] = boxes[h][c][r] + 1;
                    max = Math.max(max, boxes[nh][nc][nr]);
                    cnt--;
                }

            }

        }

        System.out.println(cnt == 0 ? max - 1 : -1);
        br.close();
    }

}