import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, K;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        Queue<int []> queue = new ArrayDeque<>();
        visited = new boolean[M][N];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            for(int j = r1; j < r2; j++){
                for(int k = c1; k < c2; k++){
                    visited[j][k] = true;
                }
            }

        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    int cnt = 1;
                    queue.add(new int []{i, j});
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();

                        for(int k = 0; k < 4; k++){
                            int nr = cur[0] + dr[k];
                            int nc = cur[1] + dc[k];

                            if(nr >= 0 && nc >= 0 && nr < M && nc < N && !visited[nr][nc]){
                                queue.add(new int []{nr, nc});
                                visited[nr][nc] = true;
                                cnt++;
                            }

                        }
                    }
                    list.add(cnt);
                }
            }
        }

        System.out.println(list.size());

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

        br.close();

    }
}