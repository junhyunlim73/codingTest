import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dh = {0,0,0,0,-1,1};
    static int[] dr = {1,-1,0,0,0,0};
    static int[] dc = {0,0,1,-1,0,0};
    static int[][][] boxes;
    static boolean[][][] visited;
    static int H, N, M;
    static int day = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boxes = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());

                    if(boxes[i][j][k] == 1){
                        q.add(new int[]{i,j,k});
                        visited[i][j][k] = true;
                    }else if(boxes[i][j][k] == 0){
                        cnt++;
                    }
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 6; i++){
                int nh = cur[0] + dh[i];
                int nr = cur[1] + dr[i];
                int nc = cur[2] + dc[i];

                if(nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if(boxes[nh][nr][nc] == 0 && !visited[nh][nr][nc]){
                    q.add(new int[]{nh, nr, nc});
                    boxes[nh][nr][nc] = boxes[cur[0]][cur[1]][cur[2]] + 1;
                    day = Math.max(day, boxes[nh][nr][nc]);
                    visited[nh][nr][nc] = true;
                    cnt--;
                }

            }

        }

        System.out.println(cnt == 0 ? day - 1 : -1);
    }
    
}